package com.cse;
import java.io.*;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

class Customer{
String name;
Long mobile;
String email;
String dbname="/cse";
String table="/customer";
String dburl="jdbc:postgresql://localhost:5432";
String user="postgres";
String pwd="password123";
    
	void get_data() throws Exception{
		
        InputStreamReader r = new InputStreamReader(System.in);    
		BufferedReader br = new BufferedReader(r); 
		       
		System.out.println("Enter Customer name : ");    
		name=br.readLine();    
		
		System.out.println("Enter Customer mobile number : ");    
		mobile=Long.parseLong(br.readLine()); 
		
		System.out.println("Enter Customer email : ");    
		email=br.readLine(); 
		
		
		
		try (Connection  c = DriverManager.getConnection(dburl+dbname,user,pwd);){
			String sql="INSERT INTO customer (name,mobile,email) VALUES (?,?,?)";
			
            
			 if (c != null) {
	                System.out.println("Connected to the database! " +dbname);
	               PreparedStatement pstmt = c.prepareStatement(sql);
	                pstmt.setString(1, name);
	                pstmt.setLong(2, mobile);
	                pstmt.setString(3, email);
	                pstmt.executeUpdate();
	                
	               
	                
	                
	            } else {
	                System.out.println("Failed to make connection! "+dbname);
	            }
	                
		}
        
        
		
	}
    

	void display_data() throws Exception{
	    		
	    System.out.println("Customer name   : "+name);    
        System.out.println("Customer mobile : "+mobile);
		System.out.println("Customer email  : "+email);


	}
}