#!/bin/sh
if [ -z "$1" ]
  then
    echo "usage : ./$0 <iface>"
else
    ip -o -6 addr show $1 | sed -e 's/^.*inet6 \([^ ]\+\).*/\1/' | grep '/128' | awk -F '/' '{print $1}'
fi

