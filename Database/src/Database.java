import java.sql.*;


public class Database 
{
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
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select Employee_id,first_name,last_name,email from Employee");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String f=rs.getString(2);
				String l=rs.getString(3);
				String e=rs.getString(4);
				System.out.println("Employee id is "+id);
				System.out.println("First name is :"+f);
				System.out.println("last name is :"+l);
				System.out.println("Email is :"+e);
					
			}
		
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

