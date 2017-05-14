#include <iostream>
#include <cstdio>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>


using namespace std;


class i_info
{
private:
	string path;
	struct stat stat_var;
public:
	void getInodeInfo();
	void displayModeofOpn();
	void getLinkIDSize();
	void displayctime();
	i_info(string str1)
	{
		path=str1;
	}

};
void i_info::getInodeInfo()
{
	int i=stat(path.c_str(),&stat_var);
	cout<<"Inode Number : "<<stat_var.st_ino<<endl;
	cout<<"Blocks allocated : "<<stat_var.st_blocks<<endl;
	cout<<"FS IO Block size : "<<stat_var.st_blksize<<endl;
}
void i_info::displayModeofOpn()
{
	cout<<"The access modes of the file are :";

	cout<<((S_IRUSR &stat_var.st_mode)?"r":"-");
	cout<<((S_IWUSR &stat_var.st_mode)?"w":"-");
	cout<<((S_IXUSR &stat_var.st_mode)?"x":"-");

	cout<<((S_IRGRP &stat_var.st_mode)?"r":"-");
	cout<<((S_IWGRP &stat_var.st_mode)?"w":"-");
	cout<<((S_IXGRP &stat_var.st_mode)?"x":"-");

	cout<<((S_IROTH &stat_var.st_mode)?"r":"-");
	cout<<((S_IWOTH &stat_var.st_mode)?"w":"-");
	cout<<((S_IXOTH &stat_var.st_mode)?"x":"-")<<endl;
}
void i_info::getLinkIDSize()
{
	cout<<"Number of links : "<<stat_var.st_nlink<<endl;
	cout<<"UID is : "<<(stat_var.st_uid)<<endl;
	cout<<"GID is : "<<(stat_var.st_gid)<<endl;
	cout<<"Size is (in bytes) : "<<(stat_var.st_size)<<endl;
}
void i_info::displayctime()
{
	cout<<"Last Status Change : "<<ctime(&stat_var.st_ctime);
	cout<<"Last Modified : "<<ctime(&stat_var.st_mtime);
	cout<<"Last Accessed : "<<ctime(&stat_var.st_atime)<<endl;
}
int main()
{
	i_info obj("/home/pict/a1.cpp");
	obj.getInodeInfo();
	obj.displayModeofOpn();
	obj.getLinkIDSize();
	obj.displayctime();
	return(0);
}
/*int main(int argc, char* argv[])
{
	if (argc > 2)
	{
        	cout <<"Usage : g++ progname.cpp input_file_path"<<endl;;
    	}
	else
	{

		string inpath=argv[2];
		cout<<"file name  "<<inpath<<endl;
		i_info obj(inpath);
		obj.getInodeInfo();
		obj.displayModeofOpn();
		obj.getLinkIDSize();
		obj.displayctime();
	}
	return 0;
}*/

