package com.cse;
import java.io.*;

class Cse

{
  public static void main(String args[]) throws Exception
   {
    System.out.println("press 1 for customer Enquiry :");
    System.out.println("press 2 for Student Enrollment : ");
    System.out.println("press 3 to search customer details by mobile number :");
    		
    int choice;
    try {
    	InputStreamReader r=new InputStreamReader(System.in);
    	BufferedReader br=new BufferedReader(r); 
    	choice=Integer.parseInt(br.readLine());
    	if(choice==1)
    	{
    		Customer sc = new Customer();
    		sc.get_data();
    		sc.db_dataupdate();
    		//sc.dis_data();
    	}
    	else if(choice==2)
    	{
    		Student s = new Student();
      
    		s.get_data();
    		s.db_dataupdate();
    		//s.dis_data();
    	}
    	else if(choice==3)
    	{
    		Customer c = new Customer();
    		c.display();
        
    	}
    } catch (Exception ex) {
        System.out.println(ex.getMessage());

    }
   }
}
