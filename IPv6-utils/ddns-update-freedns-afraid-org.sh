#!/bin/sh

ip6_addr=`./get-addr-dialog-bb.sh eth0` #
last_ip6_addr=`cat ./.last_ip6_addr 2> /dev/null`
host=`hostname -f`
auth='<user>:<password>' # freedns.afraid.org credentails
if [ "$ip6_addr" != "$last_ip6_addr" ] 
then
    curl -k "https://freedns.afraid.org/nic/update?hostname=$host&myip=$ip6_addr" --user $auth
    echo "$ip6_addr" > ./.last_ip6_addr
else
    echo "Address $ip6_addr has not changed"    
fi

