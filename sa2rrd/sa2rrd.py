""" import needed classes from rrd libraries"""
from pyrrd.rrd import RRD, RRA, DS
from pyrrd.graph import DEF, CDEF, VDEF
from pyrrd.graph import LINE, AREA, GPRINT
from pyrrd.graph import ColorAttributes, Graph
""" import subprocess to launch external commands like sar"""
import subprocess
""" import os.path to test if files exist"""
import os.path
""" import sys to handle error exits"""
import  sys
""" import re to parse sar output"""
import re
""" import time to convert time to unix stamps"""
import time
""" import platform to be able to get hostname"""
import platform
""" import optparse to parse command-line arguments"""
import optparse
 
# one day in seconds
day_secs = 60*60*24
# get hostname
hostname = platform.node()
# default path to sa files
logs_path = "/var/log/sysstat"
# name for rrd database file with CPU-load data
filename_load = ('sar_load_%s.rrd' % (hostname,))
# name for rrf database file with memory usage data
filename_mem = ('sar_mem_%s.rrd' % (hostname,))
# right range for one month period
right_range = range(1,32)
 
def get_sar_output(command):
    """ This function gets sar output, replaces all spaces between values in "|" and returns list of strings.
        For CPU load:
        ...
        09:45:01|PM|all|0.25|0.00|0.29|0.01|0.00|99.46
        09:50:01|PM|all|0.25|0.00|0.29|0.01|0.00|99.45
        09:55:01|PM|all|0.25|0.10|0.30|0.01|0.00|99.34
        ...
        And for memory usage:
        ...
        11:10:01|PM|10522976|5908216|35.96|336636|4275532|18481144|0|0.00|0
        11:15:01|PM|10522480|5908712|35.96|336636|4275652|18481144|0|0.00|0
        11:20:01|PM|10522480|5908712|35.96|336636|4275780|18481144|0|0.00|0
        ...
    """
    # get sar output
    sar_process = subprocess.Popen(command.split(" "), stdout=subprocess.PIPE)
    sar_out_raw, sar_err = sar_process.communicate()
    #repalce spaces with "|"
    sar_out = re.sub('\ +','|',sar_out_raw)
    # some cleanup
    sar_out = re.sub('\t','',sar_out)
    return sar_out.split("\n")
 
def get_archive_date(sar_raw):
    # first element in list of sar strings contains the date of archievw
    return sar_raw.split("|")[3]
 
def prepare_output_list(sar_cmd):
    """ This  parses sar strings and returns list of lists:
        ...
        [1393334101, 0.25]
        [1393334401, 0.25]
        [1393334701, 0.25]
        ...
        These items contain pairs of values - unix timestamp and value of load - rrd-ready data to update rrd databases
    """
    # get sar output
    data = get_sar_output(sar_cmd)
    res = []
    # determine right length of sar string
    right_len = int(len(data[4].split("|")))
    # get date of sa file
    date_ = get_archive_date (data[0])
    # convert date to unix timestamp, starting time for rrd database
    time_obj = time.strptime(date_, "%m/%d/%Y")
    unix_stamp_start = int(time.mktime(time_obj))
    for sar_record in data:
        sar_split = sar_record.split("|")
        if len (sar_split) == right_len: # if the list has right length
            # convert time of record to unix timestamp
            date_str = ("%s %s%s" % (date_, sar_split[0], sar_split[1]))
            time_obj = time.strptime(date_str, "%m/%d/%Y %I:%M:%S%p")
            unix_stamp = int(time.mktime(time_obj))
            try:
                if sar_cmd.split(" ")[-1] != "-r": # if sar command line doesn't end with "-r", for CPU load
                    # third element in splitted string is value of CPU load
                    res.append([unix_stamp, float(sar_split[3])])
                else:
                    # 4th element in splitted string is value of memory usage
                    res.append([unix_stamp, float(sar_split[5])])
            except ValueError:
                # sar output contains extra strings with column names
                # if ValueError is raised - value cannot be converted to float, we are passing this value
                pass
    return res
 
def dump_sar_to_rrd(sar_data, rrd_obj):
    """ This function fills RRD database with records
        row[0] is unix timestamp
        row[1] is value of CPU load or memory usage, in %"""
    for row in sar_data:
        rrd_obj.bufferValue(row[0], row[1])
    rrd_obj.update()
 
def prepare_rrds(unix_start_stamp):
    """ This function initializes Data Sources, Round-Robin Archives and createa RRD database files.
        In examples below heartbeat for DSs is set to 310 seconds, but we are awaiting updates every 300 seconds.
        Actualy, heartbeat in DS is maximum heartbeat. Sometimes, due to highload, sar cron scripts can dump
        data to binary sar files with some latency, so these 10 seconds is a reserve for such cases.
 
        In this example we will have 2 RRD databases (files) - for CPU load and memory usage.
        Every database will have 2 RRA - for last 24 hours and last month.
        All the parameters are explained in article."""
    # create DS for CPU load values
    dss1 = []
    ds1 = DS(dsName='load', dsType='GAUGE', heartbeat=310)
    dss1.append(ds1)
 
    # create DS for memory usage values
    dss2 = []
    ds2 = DS(dsName='mem', dsType='GAUGE', heartbeat=310)
    dss2.append(ds2)
    # creation of RRAs. RRAs have similar configurtion for CPU load and memory usage
    # so the will be used for creation of both databases
    rras = []
    rra1 = RRA(cf='AVERAGE', xff=0.5, steps=1, rows=288)
    rra2 = RRA(cf='AVERAGE', xff=0.5, steps=12, rows=744)
    rras.extend([rra1, rra2])
    # creating RRD database files
    myRRD_load = RRD(filename_load, ds=dss1, rra=rras, start=unix_start_stamp)
    myRRD_load.create()
    myRRD_mem = RRD(filename_mem, ds=dss2, rra=rras, start=unix_start_stamp)
    myRRD_mem.create()
    return myRRD_load, myRRD_mem
 
def draw_file(rrd_load, rrd_mem, unix_stamp_start, unix_stamp_end, graphfile, graph_width, graph_height, graph_title):
    """This function draws graph. Many parameters can be customized accordingly to your needs.
        """
    def1 = DEF(rrdfile=rrd_load.filename, vname='load', dsName='load')
    def2 = DEF(rrdfile=rrd_mem.filename, vname='mem', dsName='mem')
    cline1 = LINE(defObj=def1, color='#FFcc00', legend='Load Level')
    cline2 = LINE(defObj=def2, color='#00ccff', legend='Memory Usage')
    vdef2 = VDEF(vname='myavg', rpn='%s,AVERAGE' % def1.vname)
    constline1 = LINE(value=100, color='#990000', legend='Max')
    gprint1 = GPRINT(vdef2, '%6.2lf percent')
 
    ca = ColorAttributes()
    ca.back = '#333333'
    ca.canvas = '#333333'
    ca.shadea = '#000000'
    ca.shadeb = '#111111'
    ca.mgrid = '#CCCCCC'
    ca.axis = '#FFFFFF'
    ca.frame = '#AAAAAA'
    ca.font = '#FFFFFF'
    ca.arrow = '#FFFFFF'
 
    g = Graph(graphfile, start=unix_stamp_start, end=unix_stamp_end, vertical_label='load', color=ca)
    g.data.extend([def1,def2, cline2, vdef2, cline1, constline1, gprint1])
    g.title = graph_title
    g.width = graph_width
    g.height = graph_height
    g.write()
    print ("Graph file: %s" % (graphfile,))
# ----------------
 
def main():
    parser = optparse.OptionParser()
    parser.add_option('-d', '--day', action="store", dest="day", help="day for statistics", default="1")
    options, args = parser.parse_args()
 
    try:
        day = int(options.day)
    except ValueError:
        print "Wrong input!"
        sys.exit(1)
 
    right_range = range(1,32)
    if day not in right_range:
        print "Wrong day of month! Please check the boundaries."
        sys.exit(1)
    # aff zero before the day of number if the day < 10
    if day in range(1,10): day = ("0%s" % (day,))
 
    sa_file = ("%s/sa%s" % (logs_path, day))
    if not os.path.exists(sa_file):
        print ("No sar data for %s day (%s). Aborting..." % (day, sa_file))
        sys.exit(1)
 
    print "Processing %s..." % sa_file
    sar_cpu_load_cmd = ("sar -f %s" % (sa_file,))
    sar_mem_used_cmd = ("sar -f %s -r" % (sa_file,))
    graph_width = 800
    graph_height = 400
    graphfile = ('cpu_mem_usage_%s_%s.png' % (hostname, day))
    graph_title = ('\"%s - statistics for %s\"' % (hostname, day))
 
 
    cpu_load_list = prepare_output_list(sar_cpu_load_cmd)
    mem_used_list = prepare_output_list(sar_mem_used_cmd)
 
    #first element in cpu_load_list contains start time for graph
    unix_stamp_start = cpu_load_list[0][0] - 300
    unix_stamp_end = unix_stamp_start + day_secs
 
    myRRD_load, myRRD_mem = prepare_rrds(unix_stamp_start)
 
    dump_sar_to_rrd(cpu_load_list, myRRD_load)
    dump_sar_to_rrd(mem_used_list, myRRD_mem)
 
    draw_file(myRRD_load, myRRD_mem, unix_stamp_start, unix_stamp_end, graphfile, graph_width, graph_height, graph_title)
 
    print "Done."
 
if __name__ == "__main__":
        main()
