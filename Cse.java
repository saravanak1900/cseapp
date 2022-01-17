package com.cse;

public class Cse{    

	public static void main(String args[]) throws Exception{             
   
		Customer c = new Customer();
		c.get_data();
		System.out.println("Customer Enquiry Details ");  
        System.out.println("*************************");
		c.display_data();
	
	}    
}  