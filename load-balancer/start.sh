echo 0 > /proc/sys/net/ipv4/ip_forward
## Including rules from /etc/network/balance/pre-run/pre-run-script.pl ##
## Finished /etc/network/balance/pre-run/pre-run-script.pl ##
ip route flush all
ip rule flush
ip rule add from all lookup main pref 32766
ip rule add from all lookup default pref 32767
ip route flush table  2
ip route flush table  1
ip route add  172.20.0.0/24 dev wlan0 src 172.20.0.21
ip route add  192.168.100.0/24 dev eth0 src 192.168.100.1
ip route add  10.0.2.0/24 dev vlan1 src 10.0.2.21
ip route add default scope global nexthop via 10.0.2.1 dev vlan1 weight 1 nexthop via 172.20.0.1 dev wlan0 weight 1 
ip route add table 2 default dev wlan0 via 172.20.0.1
ip route add table 2 172.20.0.0/24 dev wlan0 src 172.20.0.21
ip route add table 2 192.168.100.0/24 dev eth0 src 192.168.100.1
ip route add table 2 10.0.2.0/24 dev vlan1 src 10.0.2.21
ip rule add from 172.20.0.21 table 2
ip rule add fwmark 2 table 2
ip route add table 1 default dev vlan1 via 10.0.2.1
ip route add table 1 172.20.0.0/24 dev wlan0 src 172.20.0.21
ip route add table 1 192.168.100.0/24 dev eth0 src 192.168.100.1
ip route add table 1 10.0.2.0/24 dev vlan1 src 10.0.2.21
ip rule add from 10.0.2.21 table 1
ip rule add fwmark 1 table 1
## Including rules from /etc/network/balance/routes/01.local_routes ##
# enter any routing commands you might want to go in
# for example:
# ip route add 192.168.100.1 dev eth0 src 198.162.1.14

## Finished /etc/network/balance/routes/01.local_routes ##
## Including rules from /etc/network/balance/routes/02.local_routes.pl ##
## Finished /etc/network/balance/routes/02.local_routes.pl ##
iptables -F
iptables -X
iptables -t nat    -F
iptables -t nat    -X
iptables -t mangle -F
iptables -t mangle -X
iptables -P INPUT    DROP
iptables -P OUTPUT   DROP
iptables -P FORWARD  DROP

iptables -N REJECTPERM
iptables -A REJECTPERM -j LOG -m limit --limit 1/minute --log-level 4 --log-prefix "REJECTED: "
iptables -A REJECTPERM -j REJECT --reject-with icmp-net-unreachable

iptables -N DROPGEN
iptables -A DROPGEN -j LOG -m limit --limit 1/minute --log-level 4 --log-prefix "GENERAL: "
iptables -A DROPGEN -j DROP

iptables -N DROPINVAL
iptables -A DROPINVAL -j LOG -m limit --limit 1/minute --log-level 4 --log-prefix "INVALID: "
iptables -A DROPINVAL -j DROP

iptables -N DROPPERM
iptables -A DROPPERM -j LOG -m limit --limit 1/minute --log-level 4 --log-prefix "ACCESS-DENIED: "
iptables -A DROPPERM -j DROP

iptables -N DROPSPOOF
iptables -A DROPSPOOF -j LOG -m limit --limit 1/minute --log-level 4 --log-prefix "DROP-SPOOF: "
iptables -A DROPSPOOF -j DROP

iptables -N DROPFLOOD
iptables -A DROPFLOOD -m limit --limit 1/minute  -j LOG --log-level 4 --log-prefix "DROP-FLOOD: "
iptables -A DROPFLOOD -j DROP

iptables -N DEBUG
iptables -A DEBUG  -j LOG --log-level 3 --log-prefix "DEBUG: "
iptables -t filter -N DOCKER
iptables -t filter -N DOCKER-ISOLATION
iptables -t filter -N DOCKER-USER
iptables -t filter -A FORWARD -j DOCKER-USER
iptables -t filter -A FORWARD -j DOCKER-ISOLATION
iptables -t filter -A FORWARD -o docker0 -j DOCKER
iptables -t filter -A DOCKER-ISOLATION -j RETURN
iptables -t filter -A DOCKER-USER -j RETURN
iptables -t nat -N DOCKER
iptables -t nat -A PREROUTING -m addrtype --dst-type LOCAL -j DOCKER
iptables -t nat -A OUTPUT ! -d 127.0.0.0/8 -m addrtype --dst-type LOCAL -j DOCKER
iptables -t nat -A DOCKER -i docker0 -j RETURN
iptables -t mangle -N MARK-DLG
iptables -t mangle -A MARK-DLG -j MARK     --set-mark 2
iptables -t mangle -A MARK-DLG -j CONNMARK --save-mark
iptables -t mangle -N MARK-SLT
iptables -t mangle -A MARK-SLT -j MARK     --set-mark 1
iptables -t mangle -A MARK-SLT -j CONNMARK --save-mark
iptables -t mangle -A PREROUTING -i eth0 -s 192.168.100.0/24 -m conntrack --ctstate NEW -m statistic --mode random --probability 1 -j MARK-SLT
iptables -t mangle -A PREROUTING -i eth0 -s 192.168.100.0/24 -m conntrack --ctstate NEW -m statistic --mode random --probability 0.5 -j MARK-DLG
iptables -t mangle -A PREROUTING -i eth0 -s 192.168.100.0/24 -m conntrack --ctstate ESTABLISHED,RELATED -j CONNMARK --restore-mark
iptables -t mangle -A PREROUTING -i wlan0 -m conntrack --ctstate NEW -j MARK-DLG
iptables -t mangle -A PREROUTING -i wlan0 -m conntrack --ctstate ESTABLISHED,RELATED -j CONNMARK --restore-mark
iptables -t mangle -A PREROUTING -i vlan1 -m conntrack --ctstate NEW -j MARK-SLT
iptables -t mangle -A PREROUTING -i vlan1 -m conntrack --ctstate ESTABLISHED,RELATED -j CONNMARK --restore-mark
iptables -A INPUT  -i lo -j ACCEPT
iptables -A OUTPUT -o lo -j ACCEPT
iptables -A INPUT -d 127.0.0.0/8 -j DROPPERM
iptables -A INPUT   -m state --state ESTABLISHED,RELATED -j ACCEPT
iptables -A FORWARD -m state --state ESTABLISHED,RELATED -j ACCEPT
iptables -A INPUT   -p tcp --tcp-flags SYN,ACK ACK -j ACCEPT
iptables -A FORWARD -p tcp --tcp-flags SYN,ACK ACK -j ACCEPT
iptables -A FORWARD -p tcp --tcp-flags SYN,ACK,FIN,RST RST -j ACCEPT
iptables -A INPUT -p icmp --icmp-type echo-request -m limit --limit 1/s -j ACCEPT
iptables -A INPUT -p icmp --icmp-type echo-request -j DROPFLOOD
iptables -A INPUT   -i eth0 -s 192.168.100.0/24 -j ACCEPT
iptables -A OUTPUT  -o eth0 -d 192.168.100.0/24  -j ACCEPT
iptables -A OUTPUT  -o eth0 -d 255.255.255.255/32  -j ACCEPT
iptables -A OUTPUT  -p udp -s 192.168.100.0/24 -j ACCEPT
iptables -A OUTPUT -o vlan1 -j ACCEPT
iptables -A OUTPUT -o wlan0 -j ACCEPT
iptables -A FORWARD -i eth0 -o wlan0 -s 192.168.100.0/24 -j ACCEPT
iptables -A FORWARD -i eth0 -o vlan1 -s 192.168.100.0/24 -j ACCEPT
iptables -A OUTPUT  -j DROPSPOOF
iptables -t nat -A POSTROUTING -o wlan0 -j MASQUERADE
iptables -t nat -A POSTROUTING -o vlan1 -j MASQUERADE
## Including rules from /etc/network/balance/firewall/01.accept ##
## This file contains iptables statements that add additional firewall rules

# allow incoming domain packets -- needed for DNS resolution
iptables -A INPUT   -p udp --source-port domain -j ACCEPT
# allow incoming NTP packets -- needed for net time protocol
iptables -A INPUT   -p udp --source-port ntp -j ACCEPT
## Finished /etc/network/balance/firewall/01.accept ##
## Including rules from /etc/network/balance/firewall/01.accept.pl ##
iptables -A INPUT -p tcp -s 192.168.100.0/24 --syn --dport ssh -j ACCEPT
## Finished /etc/network/balance/firewall/01.accept.pl ##
## Including rules from /etc/network/balance/firewall/02.forward.pl ##
iptables -A FORWARD -p udp --source-port domain -d 192.168.100.0/24 -j ACCEPT
iptables -A FORWARD -p udp --source-port ntp    -d 192.168.100.0/24 -j ACCEPT
## Finished /etc/network/balance/firewall/02.forward.pl ##
echo 1 > /proc/sys/net/ipv4/ip_forward
## Including rules from /etc/network/balance/post-run/post-run-script.pl ##
## Finished /etc/network/balance/post-run/post-run-script.pl ##
