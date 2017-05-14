import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.*;

public class Views {
	final static String url="jdbc:mysql://192.168.5.101:3306/TE3115db";
	final static String usr="TE3115";
	final static String pass="TE3115";
	public static void main(String args[])throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Connection established........");
			Connection con=DriverManager.getConnection(url, usr, pass);
			Statement st=con.createStatement();
			
			System.out.println("  !!!!! Creating Table !!!!!    ");
			String s4="create table Student(Roll_no int(4) primary key,Name varchar(10),Marks int,city varchar(10))";
			st.executeUpdate(s4);
			
			System.out.println("  Table is  created ");
			
			
			st.executeUpdate("insert into Student values(3101,'ABC',67,'Vambori')");
			System.out.println("   ---- one row is inserted ---");
			
			String s6="insert into Student values(3102,'PQR',60,'Rahuri')";
			st.executeUpdate(s6);
			System.out.println("  ---- one row is inserted ---- ");
			
			String s7="insert into Student values(3103,'LMN',70,'A.nagar')";
			int i3=st.executeUpdate(s7);
			System.out.println(" ---- one row is inserted ----"+i3);

			System.out.println("");
			ResultSet rs1=st.executeQuery("select * from Student");
			while(rs1.next())
			{
				int g=rs1.getInt(1);
				String s1=rs1.getString(2);
				int l=rs1.getInt(3);
				String c=rs1.getString(4);
				System.out.println("Roll no of Student:"+g);
				System.out.println("Name of Student :"+s1);
				System.out.println("Mobile No :"+l);
				System.out.println("City :"+c);
				System.out.println("");
				
			}
			
			System.out.println("    ----  Creating simple views  ----   ");
			String sp="create view View4 as select first_name,last_name,hire_date from Employee ";
			st.executeUpdate(sp);
			
			ResultSet rs4=st.executeQuery("select * from View4");
			while(rs4.next())
			{
				String s1=rs4.getString(1);
				String s2=rs4.getString(2);
				
				System.out.println("first Name of Emp :"+s1);
				System.out.println("last Name of Emp :"+s2);
				System.out.println("Date :"+rs4.getDate(3));
				System.out.println("");
				
			}
			
			System.out.println("    ----  Creating complex views using group by(pnmae) ----   ");
			String su="create view View1 as select pname,sum(sal) from Prof group by pname ";
			st.executeUpdate(su);
			
			ResultSet rs=st.executeQuery("select * from View1");
			while(rs.next())
			{
				String s1=rs.getString(1);
				int l=rs.getInt(2);
				System.out.println("Name of Prof :"+s1);
				System.out.println("Salary :"+l);
				System.out.println("");
				
			}
			
			System.out.println("    ----  Creating complex views with joins (Prof AND Dept AND ProfWorks)  ----   ");
			
			String s="create view View2 as select p.id,p.pname,t2.dno,t3.dname from Prof p JOIN ProfWorks t2 on p.id=t2.id Join Dept t3 on t2.dno=t3.dno ";
			st.executeUpdate(s);
			ResultSet rs2=st.executeQuery("select * from View2");
			while(rs2.next())
			{
				int l1=rs2.getInt(1);
				String s1=rs2.getString(2);
				int l=rs2.getInt(3);
				String d1=rs2.getString(4);
				System.out.println("id:"+l1);
				System.out.println("Name of Prof :"+s1);
				System.out.println("Department no: :"+l);
				System.out.println("Name of Department :"+d1);
				System.out.println("");
				
			}
			
			System.out.println("    ----  Creating complex views using aggregate funtion avg() ----   ");
			String si="create view View3 as select p.id,p.pname,p.sal,w.dno,avg(p.sal) as avg from Prof p JOIN ProfWorks w on p.id=w.id  group by w.dno";
			st.executeUpdate(si);
			ResultSet rs3=st.executeQuery("select * from View3");
			while(rs3.next())
			{
				int l1=rs3.getInt(1);
				String s1=rs3.getString(2);
				int l=rs3.getInt(3);
				int d1=rs3.getInt(4);
				int a1=rs3.getInt(5);
				System.out.println("id:"+l1);
				System.out.println("Name of Prof :"+s1);
				System.out.println("Salary :"+l);
				System.out.println(" Department no :"+d1);
				System.out.println("Average sal :"+a1);
				System.out.println("");
				
			}
			
			
			System.out.println(" ***  Creating Index  ***    ");
			//String s1="create index SIndex on Prof (id) ";
			//int i=st.executeUpdate(s1);
			
			//System.out.println(" *** Index is created ***"+i);
			
			//System.out.println(" ***  Creating  Unique Index   ***   ");
			//String s2="create unique index UiIndex on Prof (id) ";
			//int j=st.executeUpdate(s2);
			
			//System.out.println("  Index is created "+j);
			//rs2.close();
			//rs1.close();
			rs4.close();
			rs3.close();
			rs.close();
			st.close();
			con.close();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception o){
	     
				o.printStackTrace();
	  		}
	
		System.out.println("Good by");
		
	}

}