#include <iostream>
#include <unistd.h>
#include <string.h>
using namespace std;
class P{
	int fd[2],i,j;
	char a[20],buf[1024],temp;
public:
	   void p1();
	   void p2();
};
void P::p1()
{
	cout<<"\n------This is Process A-------";
	cout<<"\nEnter the String :";
	cin>>a;
	pipe(fd);
	write(fd[1],a,strlen(a));
	read(fd[0],buf,strlen(a));
    close(pipe(fd));
}
void P::p2()
{
     i=0;
     j=strlen(a)-1;
     cout<<"\n--------This is Process B---------\n";
     if(fork()== 0)
     {
       while(i<j)
       {
    	temp=a[i];
    	a[i]=a[j];
    	a[j]=temp;
    	i++;
    	j--;
       }
      write(fd[1],a,strlen(a));
      read(fd[0],buf,strlen(a));
      close(pipe(fd));
      write(1,buf,strlen(a));
     }
     else if(fork()== -1)
     {
    	 cout<<"\n unsuccessful creation...";
     }
}
int main()
{
	P w;
	w.p1();
	w.p2();
	return 0;
}
