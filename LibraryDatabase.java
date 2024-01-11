package assignment;

import java.util.Scanner;

public class LibraryDatabase  {
	 Book [] books;
	 static int bookcount;
	 Student[] student;
	 static int studentcount;
	 
	    LibraryDatabase(){
	     bookcount = 0;
	     studentcount=0;
	     books = new Book[500];
	     student=new Student[500];
	    }
	    
 
	     void AddItem(){
	    	Scanner input=new Scanner(System.in);
	    	System.out.println("How many books do you want to add ? ");
	    	int add=input.nextInt();
	    	for(int i=0;i<add;i++) {
	    	System.out.println("Enter name of Book : ");
	    	String name=input.next();
	    	System.out.println("Enter quantity of Book "+"'"+name+"' "+ ": ");
	    	int num=input.nextInt();
	    	System.out.println("Enter the ISBN of Book "+"'"+name+"' "+ ": ");
	    	int isbn=input.nextInt();
	    	Book item=new Book(name,num,isbn);
	    	books[bookcount] = item;
	        bookcount++;}
	    	System.out.println("Books added Successfully");
	    }
	    
	     
	    boolean delItem() {
	    	Scanner input=new Scanner(System.in);
	    	System.out.println("Enter the name of the book you want to delete: ");
	    	String del=input.next();
	    	for(int i=0;i<bookcount; i++) {
	    	if(del.equals(books[i].name)) { 
	    	// shifting elements
	        for(int j = i; j <bookcount - 1; j++){
	         books[j] = books[j+1];} 
	        bookcount--;
	        System.out.println("Book Deleted Successfully");
	        
	        return true; }	
	    	}
	    	System.out.println("The Book is not in Library Stock");
	    	
	    	return false;
	    	}
	    
	    
	    	public void viewavailablebook() {
	    	System.out.println("\n----------------AVAILABLE BOOKS ARE-----------------");
	    	System.out.println("NAME			STOCK			ISBN");
	    	System.out.println("----			-----			----");
	        for(int i =0; i< bookcount; i++) {
	        System.out.println(books[i].name+"			"+books[i].stock+"			"+books[i].ISBN);	 }
	    	}
	    
	    	
	    	
	    	public void modifyrecord() {
	    	Scanner input=new Scanner(System.in);
	    	System.out.println("Enter the name of the book you want to modify :");
	    	String mod=input.next();
	    	for(int i=0;i<bookcount;i++) {
	    	if(mod.equals(books[i].name)) { 
	    	System.out.println("Enter the new name of the book :");
	    	mod=input.next();
	    	books[i].name=mod;	
	    	System.out.println("Enter the new ISBN of the book :");
	    	int isbn=input.nextInt();
	    	books[i].ISBN=isbn;
	    	System.out.println("Enter the New Quantity of the book :");
	    	int newstock=input.nextInt();
	    	books[i].ISBN=newstock;
	    	
	    	}
	    		}
	    	
	    	}	
	    	
	    	
	    	boolean search() {
			Scanner input=new Scanner(System.in);
			System.out.println("Enter the name of the book you want to search : ");
			String s=input.next();
			for(int i=0; i<LibraryDatabase.bookcount; i++) {
			if(s.equals(books[i].name)) {
			System.out.println("The book is available");
			
			return true;}
			}
			System.out.println("Sorry! The Book is not available"); 
			
			return false;
			}
	    
		    boolean issue() {
				Scanner input=new Scanner(System.in);
				System.out.println("Enter the name of the book to issue/borrow : ");
				String s=input.next();
				for(int i=0; i<LibraryDatabase.bookcount; i++) {
					if(s.equals(books[i].name)) {
						if(books[i].stock>0) {
						System.out.println("Enter the Rollno. of the student : ");
						int roll=input.nextInt();
						System.out.println("Enter the issue Month in integer (1-12) : ");
						int month=input.nextInt();
						System.out.println("Enter the issue date : ");
						int date=input.nextInt();
						Student stu=new Student(roll,books[i],date,month);
						student[LibraryDatabase.studentcount]=stu;
						LibraryDatabase.studentcount++;
						books[i].stock--;
						System.out.println("The Book has been Issued ! Please Return the Book within 15 Days");
						
						return true;
						}
						else {
							System.out.println("The Book is out of Stock");
							
							return false;
						}
						}		
					}
					System.out.println("Sorry! This Book doesn't exist in the Library");
					
					return false;
					}
	    	
		    
	    	public void borrow() {	
	    	issue();
	    	}
	    
	    	
	    	
	    	boolean read() {
			Scanner input=new Scanner(System.in);
			System.out.println("Enter the name of the book you want to read : ");
			String s=input.next();
			for(int i=0; i<LibraryDatabase.bookcount; i++) {
			if(s.equals(books[i].name)) {
			if(books[i].stock>0) {
			System.out.println("You are reading the Book");
			
			return true;	}
			System.out.println("Sorry the Book is out of Stock");
			
			return false;
			}
			}System.out.println("Sorry! the Book doesn't exist in the Library");
			
			return false;
			}
	    

	    	boolean returnborrow() {
			Scanner input=new Scanner(System.in);
			System.out.println("Enter your Rollno : ");
			int s=input.nextInt();
			for(int i=0; i<studentcount; i++) {
				if(s==student[i].rollno) {
			     for(int k =i; k <studentcount - 1; k++){
			     student[k] = student[k+1];
			    } 
			    System.out.println("Enter the Date of Return");
			    int returndate=input.nextInt();
			    if((returndate-student[i].date)>15) {
			    	System.out.println("You have been fined for keeping the book for more than 15 Days!");
			    }
			    System.out.println("ThankYou for returning the Book");
			    student[i].book.stock++;
				studentcount--;
				
				return true;  	}	
			    }
			System.out.println("This Rollno has no borrowed/issued Books");
			
			return false;
					}

	   void viewissuerecord() {
	    	Scanner input=new Scanner(System.in);
	    	System.out.println("Enter the  Month in integer (1-12) you want to see record of  : ");
			int month=input.nextInt();
	    	
	    	System.out.println("------------------------------------ISSUED BOOKS ARE--------------------------------------");
	    	System.out.println("Rollno			Name of Book			ISBN			Issue Date			Issue Month");
	    	System.out.println("------			------------			----			----------			-----------");
	        for(int i =0; i<studentcount; i++) {
	        	if(student[i].month==month) {
	        System.out.println(student[i].rollno+"			"+student[i].book.name+"				"+student[i].book.ISBN+"			"+student[i].date+"			"+student[i].month);
	        	}
	        	}
	    }
	    
	    }

		
		
		
		

