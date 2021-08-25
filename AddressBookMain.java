package bridgelabzPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

	//UC5 - Using Collection Class to maintain multiple contact persons in Address Book
	public static ArrayList<AddressBookMain> person1 = new ArrayList<>();//collection class array list is used to store different contacts in address book
	public static Scanner sc = new Scanner(System.in);
	
	//Class members - UC1
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String state;
		private String pin;
		private String phNumber;
		private String email;
		
		//Constructor
		public AddressBookMain()
		{
			System.out.println("Welcome to Address Book System. "); //Welcome message in the constructor		
		}
		
		//Constructor -UC1
		public AddressBookMain(String firstName, String lastName, String address, String city, String state, String pin, String phNumber, String email)
		{
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.city = city;
			this.state = state;
			this.pin = pin;
			this.phNumber = phNumber;
			this.email = email;
		}
		
		public void insertContact()
		{
			System.out.println("Add A Contact: ");
			System.out.println("Enter your first name: ");
			firstName = sc.nextLine();
			System.out.println("Enter your last name: ");
			lastName = sc.nextLine();
			System.out.println("Enter your Address: ");
			address = sc.nextLine();
			System.out.println("Enter your city: ");
			city = sc.nextLine();
			System.out.println("Enter your state: ");
			state = sc.nextLine();
			System.out.println("Enter your city PIN Code: ");
			pin = sc.nextLine();
			System.out.println("Enter your contact number: ");
			phNumber = sc.nextLine();
			System.out.println("Enter your Email ID: ");
			email = sc.nextLine();
			person1.add(new AddressBookMain(firstName,lastName,address,city,state,pin,phNumber,email));//object creation
			System.out.println("Details Added. \n");	
		}
		
		
		//Function to edit existing contacts -UC3
		public void editContact()
		{
			//Editing contacts - UC3
			System.out.println("Enter the person's First Name: ");
			String editFirstName = sc.nextLine();
			System.out.println("Enter the person's Last Name: ");
			String editLastName = sc.nextLine();
			for (int j=0;j<person1.size();j++)
			{
				AddressBookMain contact = person1.get(j);
				if(contact.firstName.equals(editFirstName) && contact.lastName.equals(editLastName))
				{
					System.out.println("Enter your first name: ");
					firstName = sc.nextLine();
					System.out.println("Enter your last name: ");
					lastName = sc.nextLine();
					System.out.println("Enter your Address: ");
					address = sc.nextLine();
					System.out.println("Enter your city: ");
					city = sc.nextLine();
					System.out.println("Enter your state: ");
					state = sc.nextLine();
					System.out.println("Enter your city PIN Code: ");
					pin = sc.nextLine();
					System.out.println("Enter your contact number: ");
					phNumber = sc.nextLine();
					System.out.println("Enter your Email ID: ");
					email = sc.nextLine();
				}// end of if
			}// end of for
		}
		
		//Function to delete a contact-UC4
		public static void deleteContact()
		{
			//Deleting a contact UC4
			System.out.println("Enter the person's First Name: ");
			String deleteFirstName = sc.nextLine();
			System.out.println("Enter the person's Last Name: ");
			String deleteLastName = sc.nextLine();
			for (int j=0;j<person1.size();j++)
			{
				AddressBookMain contact = person1.get(j);
				if(contact.firstName.equals(deleteFirstName) && contact.lastName.equals(deleteLastName))//to delete a contact
				{
					person1.remove(contact);	//Using built in method to delete an object
					System.out.println("Contact Deleted.");
				}
			}
			
		}
		
		//Method to Display all the contents in AddressBook
		public void displayAddressBook()
		{
				System.out.println("Contacts in this Address Book: ");
				
				for(int j=0;j<person1.size();j++)
				{
					AddressBookMain object = person1.get(j);
					//Displaying the details
					System.out.println("Name: " + object.firstName + " " + object.lastName);
					System.out.println("Address: " +object.address + ", " + object.city + ", "+ object.state + " - " + object.pin);
					System.out.println("Contact Number: " + object.phNumber);
					System.out.println("Email ID: " + object.email + "\n");
				}
		}

}
