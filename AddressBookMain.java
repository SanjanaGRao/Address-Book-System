package bridgelabzPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

	//UC5 - Using Collection Class to maintain multiple contact persons in Address Book
	public static ArrayList<AddressBookMain> person=new ArrayList<>();//collection class array list is used to store different contacts in address book
	
	//Class members - UC1
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String state;
		private String pin;
		private String phNumber;
		private String email;
		
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
		
		
		public void Display()
		{	
			//Displaying the details
			System.out.println("Name: " + firstName + " " + lastName);
			System.out.println("Address: " +address + ", " + city + ", "+ state + " - " + pin);
			System.out.println("Contact Number: " +phNumber);
			System.out.println("Email ID: " + email + "\n");
		}
		
		//Function to edit existing contacts -UC3
		public void editContact(String firstName, String lastName, String address, String city, String state, String pin, String phNumber, String email)
		{
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.city = city;
			this.state = state;
			this.pin = pin;
			this.phNumber = phNumber;
			this.email=email;
		}
		
		//Function to delete a contact-UC4
		public static void deleteContact(AddressBookMain deletionObject)
		{
			person.remove(deletionObject); //using built in method to remove objects
			
		}
		

	public static void main(String[] args) {
		//Display Message. 
		System.out.println("Welcome to Address Book Program");
		
		Scanner sc = new Scanner(System.in);
		/*
		 * @params firstName,lastName,address,city,state,pin,phNumber and email are local variables
		 */
		String firstName;
		String lastName;
		String address ;
		String city;
		String state;
		String pin ;
		String phNumber, email;
		
		int k = 1;
		
		do
		{
			System.out.println("Enter your choice\n 1) Add Contact \n 2) Edit existing Contact\n 3) Delete contact\n 4) Display Address Book\n 5) Exit"); //user selection
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: {
				System.out.println("Add Contacts: ");
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
				person.add(new AddressBookMain(firstName,lastName,address,city,state,pin,phNumber,email));//object creation
				System.out.println("Details Added. \n");	
				break;
			} //end of case 1
			case 2:{
				//Editing contacts - UC3
				System.out.println("Enter the person's First Name: ");
				String editFirstName = sc.nextLine();
				System.out.println("Enter the person's Last Name: ");
				String editLastName = sc.nextLine();
				for (int j=0;j<person.size();j++)
				{
					AddressBookMain contact = person.get(j);
					if(contact.firstName.equals(editFirstName) && contact.lastName.equals(editLastName))
					{
						int edit1=j;
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
						contact.editContact(firstName,lastName,address,city,state,pin,phNumber,email);//calling Edit Contact
					}// end of if
				}// end of for
				break;
			}// end of case 2
			case 3:{
				//Deleting a contact UC4
				System.out.println("Enter the person's First Name: ");
				String deleteFirstName = sc.nextLine();
				System.out.println("Enter the person's Last Name: ");
				String deleteLastName = sc.nextLine();
				for (int j=0;j<person.size();j++)
				{
					AddressBookMain contact = person.get(j);
					if(contact.firstName.equals(deleteFirstName) && contact.lastName.equals(deleteLastName))//to delete a contact
					{
						deleteContact(contact);
						System.out.println("Contact Deleted.");
					}
				}
				break;
			}//end of case 3
			case 4: {
				System.out.println("Contacts in Address Book: ");
				for(int j=0; j<person.size() ;j++)
				{
					AddressBookMain contact = person.get(j);
					System.out.println("Contact details of person: "+ (j+1));
					contact.Display();
				}
				break;
			} //end of case 4
			case 5: {
				System.out.println("Exit.");
				break;
			} // end of case 5
			default: 
				System.out.println("Enter Valid Option");
			}// end of switch
			
		}while(k!=5);
		sc.close();
	}

}
