package assignment;

import java.util.Scanner;

public class Admin {
				
			private int password=12345;

			public void setPassword(int password) {
				this.password=password ;
			}

			public int getPassword() {
				return password;
			}
			
			
			
			  boolean authentication(){
				 Scanner input=new Scanner(System.in);
				 System.out.println("Enter Password");
				 int pass=input.nextInt();
				 if(this.password==pass) {
					 System.out.println("Login Successful");
					 return true;
				 }
				 System.out.println("Incorrect password!\n");
				
				 return false;	       
			       }
			 
			  
		
	}
