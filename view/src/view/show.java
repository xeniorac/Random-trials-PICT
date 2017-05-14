package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.*;





public class show implements ActionListener, ItemListener{

	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://192.168.5.101:3306/TE3107db";

	
	   static final String USER = "TE3107";
	   static final String PASS = "TE3107";
	   
	   Connection conn = null;
	   Statement stmt = null;
	
	
	
	JTextArea txtarea;
	JTextField txtShow;
	JButton btnView,btnIndex;
	JFrame f;
	JComboBox<String> c1;
	JRadioButton rdAggregate,rdJoins,rdGrouping;
	JTextField txtSimple;
	//JLabel table;
	JButton clear;
	
	
	show()
	{
		String [] str={"Simple","Complex"};

		
		f=new JFrame();
	
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(300,300);
		f.setTitle("Welcome...");
		f.setLocation(400,400);
		
		c1=new JComboBox<String>(str);

		
		btnView=new JButton("View");
		btnIndex=new JButton("Index");

		txtShow=new JTextField();
		txtShow.setBounds(600, 100, 400, 50);
		txtarea=new JTextArea();
		txtarea.setBounds(600,300,200,300);
		
		rdAggregate=new JRadioButton("Aggregate");
		rdJoins=new JRadioButton("Joins");
		rdGrouping=new JRadioButton("Grouping");
		
		txtSimple=new JTextField(20);
	//	table=new JLabel("Enter the table name");
		
		btnView.setBounds(100, 100, 100, 50);
		btnIndex.setBounds(100, 200, 100, 50);
		txtSimple.setBounds(900, 100, 100, 50);
	//	table.setBounds(700, 100, 200, 50);
		
		txtSimple.setVisible(false);
//		table.setVisible(false);

		clear=new JButton("Clear");
		clear.setBounds(100, 400, 100, 50);
		f.add(txtShow);
		f.add(txtarea);
		
		f.add(btnView);
		f.add(btnIndex);
		f.add(txtSimple);
	//	f.add(table);
		
		f.add(clear);
		
		f.add(c1);

		f.add(rdAggregate);
		f.add(rdGrouping);
		f.add(rdJoins);
		
		clear.addActionListener(this);
		btnView.addActionListener(this);
		btnIndex.addActionListener(this);
		c1.addItemListener(this);
	}






@Override
public void actionPerformed(ActionEvent ae) {
	
	if(ae.getSource()==btnView)
	{
		c1.setBounds(300,100,100,50);
		c1.setVisible(true);
		   //  Database credentials
	
		/*   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		    // conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      conn = DriverManager.getConnection(DB_URL,"root","");
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		
		String sql1;
		 
	    sql1 = " select * from one";
	    ResultSet rs1 = stmt.executeQuery(sql1);

	    while(rs1.next())
	    {
	    int emp_id  = rs1.getInt("emp_id");
	    
	    String first_name = rs1.getString("first_name");
	    System.out.print("ID " + emp_id+"\n");
	    System.out.print("First_name... " + first_name+"\n");
	    
	    
	  	    txtShow.setText(sql1);
	  	   
	     txtarea.append("First_name... " + first_name+"\n"+ "emp_id ..."+emp_id+"\n");
	     
	    }
		   }
catch(Exception e)
{
System.out.println("error.....");
}
	    */
		   }
	
		   
	   if(ae.getSource()==btnIndex)
	    {
		   try{
			 //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			    // conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      conn = DriverManager.getConnection(DB_URL,"TE3107","TE3107");
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			
	    	  String sql2;
	    	  sql2="Index is created on Employee table on emp_id field......";
	  	  /*  sql2="select * from Employee";
	  	    ResultSet rs2 = stmt.executeQuery(sql2);
	  	    while(rs2.next())
	  	    {
	  	    	System.out.println("Index is created.....");
	  	    	int emp_id  = rs2.getInt("emp_id");
	  		    
	  		    String first_name = rs2.getString("first_name");
	  		  String last_name = rs2.getString("last_name");
	  		    
	  		    System.out.print("ID " + emp_id+"\n");
	  		    System.out.print("Last_name... " + last_name+"\n");
	  		    
	  		    txtShow.setText(sql2);
	  		  	   
	  		     txtarea.append("First_name... " + first_name+"\n"+"Last_name... " + last_name+"\n"+ "emp_id ..."+emp_id+"\n");
	  		     
	  	    }*/
	    			  txtShow.setText(sql2);
		   }
	  	    catch(Exception e)
	  	    {}
	  	    }
	  	    
	   if(ae.getSource()==clear)
	   {
		   txtarea.setText("");
		   txtShow.setText("");
	   }
	   if(ae.getSource()==rdAggregate)
	   {
		   rdJoins.setVisible(false);
			rdGrouping.setVisible(false);

		   
		   
		
			
	   }
	    	
	    }
	    
	

	
	


public static void main(String r[])
{
	show d=new show();	
}




@Override
public void itemStateChanged(ItemEvent ie) {

 if(ie.getItem()=="Simple")
{
	
	rdAggregate.setVisible(false);
	rdJoins.setVisible(false);
	rdGrouping.setVisible(false);
	
	txtSimple.setVisible(true);
	//table.setVisible(true);
  
	
	  try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	    // conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      conn = DriverManager.getConnection(DB_URL,"TE3107","TE3107");
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	
	String sql1;
	 
    sql1 = " select * from one";
    ResultSet rs1 = stmt.executeQuery(sql1);

    while(rs1.next())
    {
    int emp_id  = rs1.getInt("emp_id");
    
    String first_name = rs1.getString("first_name");
    System.out.print("ID " + emp_id+"\n");
    System.out.print("First_name... " + first_name+"\n");
    
    
  	    txtShow.setText(sql1);
  	   
     txtarea.append("First_name... " + first_name+"\n"+ "emp_id ..."+emp_id+"\n");
     
    }
	   }
	  catch(Exception e)
	  {
		  System.out.println("error.....");
	  }	
	
	
	
	   }



if(ie.getItem()=="Complex")
{
	
	
	rdAggregate.setBounds(300,200,100,50);
	rdJoins.setBounds(500,200,100,50);
	rdGrouping.setBounds(700,200,100,50);
	
	rdAggregate.setVisible(true);
	rdJoins.setVisible(true);
	rdGrouping.setVisible(true);
	txtSimple.setVisible(false);
//	table.setVisible(false);

	   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		    // conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      conn = DriverManager.getConnection(DB_URL,"TE3107","TE3107");
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		
		String sql3;
		 
	  sql3 = " select count(*) from one ";
	  ResultSet rs3 = stmt.executeQuery(sql3);

	  while(rs3.next())
	  {
	  int count  = rs3.getInt("count(*)");
	  

	   System.out.println("Aggregate function");
	  System.out.print("Count " + count+"\n");
	
		    txtShow.setText(sql3);
		  
		  // txtarea.append(count);
	  }
	  //////////////////////////////////
		    String sql4;
			 
			  sql4 = " select first_name from one GROUP BY emp_id";
 
			  ResultSet rs4 = stmt.executeQuery(sql4);
	  
			  while(rs4.next())
			  {
				  String first_name = rs4.getString("first_name");
				    System.out.print("Grouping function........\n");
				    System.out.print("First_name... " + first_name+"\n");
	   
	  }
	  ////////////////////////
			  String sql5;
				 
	 sql5 = " select e.first_name,e.last_name from one e join three t on e.emp_id=t.emp_id";

 
			  ResultSet rs5 = stmt.executeQuery(sql5);
	  
			  while(rs5.next())
			  {
				  System.out.print("Join function........\n");
				    String first_name = rs5.getString("first_name");
				   
				    System.out.print("First_name... " + first_name+"\n");
				    String last_name = rs5.getString("last_name");
					   
				    System.out.print("Last_name... " + last_name+"\n");
	   
		//////////////////////	  
	   }
	  
	   } 
		  catch(Exception e)
		  {
			  System.out.println("error.....");
		  }	






}
	



}
}