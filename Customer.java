package com.cse;
import java.io.*;  
import java.sql.Connection;
import java.sql.PreparedStatement; // used update the data into the database 
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;


class Customer implements CseInterface
{
 String name;
 Long mobile;
 String email;
 String dbname="/cse";
 String table="/customer";
 String dburl="jdbc:postgresql://localhost:5432";
 String user="postgres";
 String pwd="password123";
    
	public void get_data(){
		
			try {
			        InputStreamReader r = new InputStreamReader(System.in);    
					BufferedReader br = new BufferedReader(r); 
					       
					System.out.println("Enter Customer name : ");    
					name=br.readLine();    
					
					System.out.println("Enter Customer mobile number : ");    
					mobile=Long.parseLong(br.readLine()); 
					
					System.out.println("Enter Customer email : ");    
					email=br.readLine(); 
					
			} catch (IOException ex)	{
				System.out.println(ex.getMessage());
				
			}
			
		}
        
        
		
	
    

	   void display_data() throws Exception{
	    		
	    System.out.println("Customer name   : "+name);    
        System.out.println("Customer mobile : "+mobile);
		System.out.println("Customer email  : "+email);


	}

	
	public void db_dataupdate() {
		
				try (Connection  c = DriverManager.getConnection(dburl+dbname,user,pwd);){
					String sql="INSERT INTO customer (name,mobile,email) VALUES (?,?,?)";
					
		            
							 if (c != null) {
					                System.out.println("Connected to the database! " +dbname);
					                PreparedStatement pstmt = c.prepareStatement(sql);
					                pstmt.setString(1, name);
					                pstmt.setLong(2, mobile);
					                pstmt.setString(3, email);
					                pstmt.executeUpdate();
					                System.out.println(name+" "+mobile+" "+email+" Added to table "+table);
				                                           
					                
					            } else {
					                System.out.println("Failed to make connection! "+dbname);
					            }
			                
			    } catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
    }
	
	public void display() {
		
				try (Connection  c = DriverManager.getConnection(dburl+dbname,user,pwd);)
				{
					 String sql="SELECT * FROM customer WHERE mobile=?";
					 Long mobile;
		            
								 if (c != null) {
						                System.out.println("Connected to the database! " +dbname);
						                InputStreamReader r = new InputStreamReader(System.in);    
						        		BufferedReader br = new BufferedReader(r); 
						        		System.out.println("Enter the mobile :");
						        	    mobile=Long.parseLong(br.readLine());
						                PreparedStatement pstmt = c.prepareStatement(sql);
						               
						                pstmt.setLong(1, mobile);
						                
						                ResultSet rs = pstmt.executeQuery();
						                while (rs.next()) {
						                    System.out.println(rs.getString("name") + "\t"
						                            + rs.getLong("mobile") + "\t"
						                            + rs.getString("email"));
						                
						                 }
								 }
								 else {
						                System.out.println("Failed to make connection! "+dbname);
						         }
				} catch (Exception ex) {
		        System.out.println(ex.getMessage());
		    }
	}
}