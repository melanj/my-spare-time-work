package com.activesplash.util.mysql.backup;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class BackupAction extends ActionSupport {

    public BackupAction() {

    }
    private static final long serialVersionUID = 2471910747833998708L;
    private static final String OUTPUT_GZIP_FILE = "D:\\bb\\test.gz";

    @Override
    public String execute() throws Exception {

        File test=new File("D:\\bb\\test.sql");
        FileWriter fw=null;
        String host = "localhost";
        String user ="root";
        String pw = "root";
        try{
        fw = new FileWriter(test);
        Runtime rt = Runtime.getRuntime();
        Process child = rt.exec("mysqldump -h"+host+" -u"+user+" -p"+pw+" j2ee");
        GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream(OUTPUT_GZIP_FILE));
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("D:\\bb\\test.zip"));
        ZipEntry ze= new ZipEntry("test.sql");
    	zos.putNextEntry(ze);
        
        InputStream in = child.getInputStream();
        InputStreamReader xx = new InputStreamReader(in,"latin1");
        char[] chars=new char[1];
      //  byte[] chars=new byte[1];
        int ibyte=0;
        while((ibyte=xx.read(chars))>0)
        {
        fw.write(chars);
        gzos.write((int)chars[0]);
        zos.write((int)chars[0]);
        }
        fw.close();
        gzos.finish();
    	gzos.close();
        zos.closeEntry();
    	zos.close();

       }catch (Exception e) {
           return "fail";
        }
    return SUCCESS;
    }



}