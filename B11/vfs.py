
Roll_no:3115

import os
import sys
import shutil

def mymkdir():
	dirname = raw_input("ENTER DIRECTORY NAME: ")
	if not os.path.exists(dirname):
		os.makedirs(dirname)
	else:
		print("DIRECTORY "+dirname+" ALREADY EXISTS...")

def mychdir():
	dirname = raw_input("ENTER DIRECTORY NAME: ")
	if os.path.exists(dirname):
		os.chdir(dirname)
	else:
		print("DIRECTORY "+dirname+" DOESN'T EXISTS...")

def mychroot():
	dirname = raw_input("ENTER DIRECTORY NAME: ")
	if os.path.exists(dirname):
		os.chroot(dirname)
	else:
		print("DIRECTORY "+dirname+" DOESN'T EXISTS...")

def mylink():
	src = raw_input("ENTER SOURCE FILENAME: ")
	dest = raw_input("ENTER DESTINATION LINK NAME: ")
	if os.path.isfile(src):
		os.link(src,dest)
	else:
		print("SOURCE FILE DOES NOT EXISTS...")

def myls():
	dirnames = os.listdir(os.getcwd())
	for filename in dirnames:
		print(filename)

def mystat():

	filename = raw_input("ENTER FILE/DIRECTORY NAME: ")
	if os.path.isfile(filename) or os.path.exists(filename):
		info = os.lstat(filename)
		print("DEV ID: "+str(info.st_dev)+"\tINODE: "+str(info.st_ino))
		print("PROTECTION: "+str(info.st_mode)+"\tHARD LINKS: "+str(info.st_nlink))
		print("USER ID: "+str(info.st_uid)+"\tGROUP ID: "+str(info.st_gid))
		print("SIZE: "+str(info.st_size)+"\tBLOCK SIZE: "+str(info.st_blksize))
		print("BLOCKS: "+str(info.st_blocks))
	else:
		print("FILE/DIRECTORY NOT FOUND")

def mycatread():
	filename = raw_input("ENTER FILENAME: ")
	if os.path.isfile(filename):
		fileptr = open(filename,"r+")
		print(fileptr.read())
	else:
		print("FILE "+filename+" NOT FOUND")

def myrm():
	filename = raw_input("ENTER FILENAME: ")
	if os.path.isfile(filename):
		os.remove(filename)
	else:
		print("FILE "+filename+" NOT FOUND")

def myrmdir():
	dirname = raw_input("ENTER DIRECTORY: ")
	if os.path.exists(dirname):
		os.removedirs(dirname)
	else:
		print("DIRECTORY "+dirname+" NOT FOUND")

def myrename():
	src = raw_input("ENTER SOURCE FILENAME: ")
	dest = raw_input("ENTER DESTINATION FILENAME: ")
	if os.path.isfile(src):
		os.rename(src, dest)
	else:
		print("FILE "+src+" NOT FOUND")

def mycp():
	src = raw_input("ENTER SOURCE FILENAME: ")
	dest = raw_input("ENTER DESTINATION FILENAME: ")
	if os.path.isfile(src):
		shutil.copy2(src, dest)
	else:
		print("FILE "+src+" NOT FOUND")


def mycatwrite():
	filename = raw_input("ENTER FILENAME: ")
	print("ENTER DATA IN FILE...\n")
	datatowrite = sys.stdin.read()
	fileptr = open(filename,"w+")
	fileptr.write(datatowrite)
	fileptr.close()
	
		
def main():
	print("WELCOME TO PYTHON VIRTUAL FILE SYSTEM...")
	print("FOR HELP ENTER 'help' command...")
	while 1 :
		command = raw_input(".\n.\npvfs>>>  ")
		
		if command == 'help':
			print("LIST OF COMMANDS\n_____________________________________")
			print("mkdir: makes direcory (recursively)")
			print("chdir: changes current working directory")
			print("chroot: changes current root directory")
			print("pwd: prints current working directory")
			print("link: creates a link")
			print("ls: displays contents of current directory")
			print("stat: displays internal details and status of file")
			print("catread: reads a file and displays its content")
			print("rm: deletes a file")
			print("rmdir: deletes a directory")
			print("rename: renames a file")
			print("cp: copies file")
			print("catwrite: writes data in file")

		elif command == 'mkdir':
			mymkdir()
		
		elif command == 'chdir':
			mychdir()

		elif command == 'chroot':
			mychroot()

		elif command == 'pwd':
			print("CURRENT WORKING DIRECTORY: "+ os.getcwd())

		elif command == 'link':
			mylink()

		elif command == 'ls':
			myls()

		elif command == 'stat':
			mystat()

		elif command == 'catread':
			mycatread()

		elif command == 'rm':
			myrm()

		elif command == 'rmdir':
			myrmdir()

		elif command == 'rename':
			myrename()

		elif command == 'cp':
			mycp()

		elif command == 'catwrite':
			mycatwrite()

		elif command == 'exit':
			exit(0)
		
		else:
			print("INVALID COMMAND PLEASE CHECK HELP...")
main()
