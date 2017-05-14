#!/usr/bin/python

import os, sys


class Pipe:
	print "The child will write text to a pipe and "
	print "the parent will read the text written by child..."

def reverse(s):
    txt = ''
    for i in range(len(s)-1, -1, -1):
        txt += s[i]
	print txt
    return
# file descriptors r, w for reading and writing
r, w = os.pipe() 
s = raw_input("Enter text: ")
processid = os.fork()
if processid:
    # This is the parent process 
    # Closes file descriptor w
    os.close(w)
    r = os.fdopen(r)
    print "Parent reading"
    print s
    str = r.read()
    print "text =", str   
    sys.exit(0)
else:
    # This is the child process
    os.close(r)
    w = os.fdopen(w, 'w')
    print "Child writing"
    reverse(s);
    w.write("Text written by child...")
    w.close()
    print "Child closing"
    sys.exit(0)


