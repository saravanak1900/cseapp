package com.cse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class Student extends Customer implements CseInterface
{ 
	
  String name;
  Long mobile;
  String email;
  String college;
  String address;
  String course;
  
  String dbname="/cse";
  String table="/student";
  String dburl="jdbc:postgresql://localhost:5432";
  String user="postgres";
  String pwd="password123";
  
  
 public void get_data() 
  {
    try {
    System.out.println("Enter the name :");
    InputStreamReader r=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(r); 
    name = br.readLine();
    System.out.println("Enter the mobile :");
    mobile=Long.parseLong(br.readLine());
    System.out.println("Enter the email :");  
    email = br.readLine();
    System.out.println("Enter the college");
    college = br.readLine();
    System.out.println("Enter the address");
    address = br.readLine();
    System.out.println("Enter the course");
    course = br.readLine();
    } catch ( Exception ex)
    {System.out.println(ex.getMessage());}    
    
  }
 public void db_dataupdate() {
	 
	 try (Connection  c = DriverManager.getConnection(dburl+dbname,user,pwd);){
			String sql="INSERT INTO student (name,mobile,email,college,address,course) VALUES (?,?,?,?,?,?)";
			
	        
			 if (c != null) {
	                System.out.println("Connected to the database! " +dbname);
	                PreparedStatement pstmt = c.prepareStatement(sql);
	                pstmt.setString(1, name);
	                pstmt.setLong(2, mobile);
	                pstmt.setString(3, email);
	                pstmt.setString(4, college);
	                pstmt.setString(5, address);
	                pstmt.setString(6, course);
	                pstmt.executeUpdate();
	                System.out.println(name+" "+mobile+" "+email+" "+college+" "+address+" "+course+"  Added to table " +table);
	               
	                
	                
	            } else {
	                System.out.println("Failed to make connection! "+dbname);
	            }
	                
		}catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	    }
	 
 }
  

}
