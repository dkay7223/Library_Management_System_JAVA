package assignment;

import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input= new Scanner(System.in);
		
		LibraryDatabase library=new LibraryDatabase();
		Admin admin=new Admin();
		
		char choice2='*';
		
		do {
		System.out.println(" ___________________________________________");
		System.out.println("|_________LIBRARY MANAGEMENT SYSTEM_________|");
		System.out.println("       Enter # : Switch to Admin Mode");
		System.out.println("       Enter $ : Switch to Student Mode");
		System.out.println("       Enter < : Exit");
		
		
		System.out.println("Enter your choice : ");
		char choice=input.next().charAt(0);  
		switch(choice)
		{
		case '#': {
		if(admin.authentication()) {
		System.out.println(" __________________________________________________");
		System.out.println("|________(Admin)_LIBRARY MANAGEMENT SYSTEM_________|");
		System.out.println("       Press 1 : Add Book");
		System.out.println("       Press 2 : Modify Book Record");
		System.out.println("       Press 3 : Delete admin Book");
		System.out.println("       Press 4 : Issue Book");
		System.out.println("       Press 6 : View all available Books");
		System.out.println("       Press 7 : View the records of all books issued in admin particular month");
		System.out.println("       Press 8 : Change the Password");
		System.out.println("       Press 9 : Go back to General Menu");
		
		System.out.println("Enter your choice : ");
		int choice1=input.nextInt();  
		switch(choice1)
		{
		case 1: {library.AddItem();break;}
		case 2: {library.modifyrecord();break;}
		case 3: {library.delItem();break;}
		case 4: {library.issue();break;}
		case 6: {library.viewavailablebook();break;}
		case 7: {library.viewissuerecord();break;}
		case 8: {
				System.out.println("Enter New Password");
				int newpass=input.nextInt();
				admin.setPassword(newpass);
				System.out.println("Password Changed");
				break;}
		case 9: {break;}
		default :{System.out.println("Invalid Choice !");}}}break;}
		
		
		case '$': {	System.out.println(" _____________________________________________________");
		System.out.println("|_________(Student)_LIBRARY MANAGEMENT SYSTEM_________|");
		System.out.println("       Press 1 : Search admin Book ");
		System.out.println("       Press 2 : Borrow admin Particular Book");
		System.out.println("       Press 3 : Read admin particular book");
		System.out.println("       Press 4 : Return Borrowed Book");
		System.out.println("       Press 5 : Go back to General Men");
		
		System.out.println("Enter your choice : ");
		int choice1=input.nextInt();
		switch(choice1)
		{
		case 1: {library.search();;break;}
		case 2: {library.borrow();break;}
		case 3: {library.read();break;}
		case 4: {library.returnborrow();break;}
		case 5: {break;}
		default :{System.out.println("Invalid Choice !");}
		}	;break;}
		
		case '<': {System.out.println("\n\n\t\tTHANK YOU !!!!!!");choice2='<';break;}
		
		default :{System.out.println("Invalid Choice !");}}
		
		
		}while(choice2!='<');

	
		
	}
}
