package bridgelabzPractice;

import java.util.Scanner;

public class AddressBookMain {
	
	public static  int n=0;
	
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
		public static void deleteContact(int del,AddressBookMain[] person)
		{
			int i;
			if(del==n-1)
			{
				person[del]=null;
			}
			else
			{
				for(i=del;i<n-1;i++)
				{
					person[i] = person[i+1];
				}
				person[i]=null;   //to delete the object
			}
			
		}
		

	public static void main(String[] args) {
		//Display Message. 
		System.out.println("Welcome to Address Book Program");
		
		Scanner sc = new Scanner(System.in);
		AddressBookMain[] person = new AddressBookMain[20]; //Multiple contacts can be created
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
				person[n]=new AddressBookMain(firstName,lastName,address,city,state,pin,phNumber,email);//object creation
				n++;
				System.out.println("Details Added. \n");
				//person[n].Display();		
				break;
			} //end of case 1
			case 2:{
				//Editing contacts - UC3
				System.out.println("Enter the person's First Name: ");
				String editFirstName = sc.nextLine();
				System.out.println("Enter the person's Last Name: ");
				String editLastName = sc.nextLine();
				for (int j=0;j<n;j++)
				{
					if(person[j].firstName.equals(editFirstName) && person[j].lastName.equals(editLastName))
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
						person[edit1].editContact(firstName,lastName,address,city,state,pin,phNumber,email);//calling Edit Contact
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
				for (int j=0;j<n;j++)
				{
					if(person[j].firstName.equals(deleteFirstName) && person[j].lastName.equals(deleteLastName))//to delete a contact
					{
						int delete1=j;
						deleteContact(delete1,person);
						n=n-1;
					}
				}
				break;
			}//end of case 3
			case 4: {
				System.out.println("Contacts in Address Book: ");
				for(int j=0; j<n ;j++)
				{
					System.out.println("Contact details of person: "+ (j+1));
					person[j].Display();
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
