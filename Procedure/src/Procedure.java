

import java.sql.*;


public class Procedure {


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
			System.out.println("Creating statements.............");
			Statement st1=con.createStatement();
int i=st1.executeUpdate("CREATE PROCEDURE Dept1(IN id int(5),OUT name varchar(10)) begin select dept_name INTO name from Departments where location_id=id; end;");
System.out.println(""+i);
			String r1="{call Dept1 (?, ?)}";
			CallableStatement st= con.prepareCall(r1);
			 int Loc_id = 50;
		      st.setInt(1, Loc_id); // This would set ID as 102
		      // Because second parameter is OUT so register it
		      st.registerOutParameter(2, java.sql.Types.VARCHAR);
		      
		      //Use execute method to run stored procedure.
		      System.out.println("Executing stored procedure..." );
		      st.execute();

		      //Retrieve employee name with getXXX method
		      String Name = st.getString(2);
		      System.out.println("Department Name with ID:" + 
		               Loc_id + " is " + Name);
		 st1.close();
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

