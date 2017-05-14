import socket
import sys

s = socket.socket()
s.connect(("localhost",9000))
f=open ("dpts.txt", "r") 
l = f.read(1024)
while (l):
    s.send(l)
    l = f.read(1024)
s.close()
