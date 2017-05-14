import java.sql.*;

public class Data1 {
	static final String url="jdbc:mysql://192.168.5.101:3306/TE3115db";
	 
	static final String usr="TE3115";
	static final String pass="TE3115";
	
	public static void main(String args[])throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection is established..........");
			Connection con=DriverManager.getConnection( url,usr,pass);
			//Statement st=con.createStatement();
			Statement st=con.createStatement();
			System.out.println("------Query 1--------");
			ResultSet rs2=st.executeQuery("select first_name,last_name,salary,Employee_id from Employee where hire_date >= '2006-1-1'"); 
			while(rs2.next())
			{
				String i=rs2.getString(1);
				String n=rs2.getString(2);
				int s=rs2.getInt(3);
				int id=rs2.getInt(4);
				System.out.println("Employee id is "+i);
				System.out.println("First name is :"+n);
				System.out.println("Salary is :"+s);
				System.out.println("Dept id is :"+id);
					
			}
			System.out.println("------Query 3--------");
		       ResultSet rs3= st.executeQuery("select first_name,last_name from Employee where first_name='%a%' OR last_name='%a%'");
		       while(rs3.next())
				{
					int i=rs3.getInt(1);
					String n=rs3.getString(2);
					String s=rs3.getString(3);
					System.out.println("Employee id is "+i);
					System.out.println("First name is :"+n);
					System.out.println("Last name is :"+s);
				}
			System.out.println("------Query 4--------");
			
			st.executeUpdate("update Employee set salary='46000' where department_id='30' ");
	
			ResultSet rs=st.executeQuery("select * from Employee where department_id= '30'");
			while(rs.next())
			{
				int i=rs.getInt(1);
				String n=rs.getString(2);
				int s=rs.getInt(8);
				int id=rs.getInt(9);
				System.out.println("Employee id is "+i);
				System.out.println("First name is :"+n);
				System.out.println("Salary is :"+s);
				System.out.println("Dept id is :"+id);
					
			}
			System.out.println("");
			System.out.println("-----------Query 5-----------------");
		int i1=st.executeUpdate("delete from Job_history where salary <'50000'");
		ResultSet rs1=st.executeQuery("select * from Job_history");
		while(rs1.next())
		{
			int i2=rs1.getInt(1);
			int n1=rs1.getInt(4);
			int s1=rs1.getInt(5);
			int id1=rs1.getInt(6);
			System.out.println("Job id is "+i2);
			System.out.println(" :"+n1);
			System.out.println("Salary is :"+s1);
			System.out.println("Dept id is :"+id1);
				
		}
		System.out.println("-----------Query 6-----------------");
		ResultSet rs6=st.executeQuery("select a.Employee_id,a.first_name,a.last_name,a.hire_date,b.job_title from Employee a,Jobs b where a.hire_date > '1999' and b.job_title='clerk'");
		while(rs6.next())
		{
			int i2=rs6.getInt(1);
			String n1=rs6.getString(2);
			String s1=rs6.getString(3);
			int id1=rs6.getInt(4);
			String h=rs6.getString(5);
			System.out.println("Job id is "+i2);
			System.out.println(" First Name:"+n1);
			System.out.println("Last Name is :"+s1);
			System.out.println("Date is :"+id1);
			System.out.println("Title: "+h);
				
		}
		rs6.close();
		rs3.close();
		rs2.close();
		rs1.close();
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
	

