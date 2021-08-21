package bridgelabzPractice;

import java.util.Scanner;

public class AddressBookMain {
	
	//Class members - UC1
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String state;
		private String pin;
		private String phNumber;
		
		//Constructor -UC1
		public AddressBookMain(String firstName, String lastName, String address, String city, String state, String pin, String phNumber)
		{
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.city = city;
			this.state = state;
			this.pin = pin;
			this.phNumber = phNumber;
		}

	public static void main(String[] args) {
		//Display Message. 
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of contacts to add: ");
		int n = sc.nextInt();
		
		//Multiple contacts can be created
		for(int i =0; i<n ; i++)
		{
			System.out.println("Enter your first name: ");
			String firstName = sc.nextLine();
			System.out.println("Enter your last name: ");
			String lastName = sc.nextLine();
			System.out.println("Enter your Address: ");
			String address = sc.nextLine();
			System.out.println("Enter your city: ");
			String city = sc.nextLine();
			System.out.println("Enter your state: ");
			String state = sc.nextLine();
			System.out.println("Enter your city PIN Code: ");
			String pin = sc.nextLine();
			System.out.println("Enter your contact number: ");
			String phNumber = sc.nextLine();
			
			//Creation of Object - UC2
			AddressBookMain person = new AddressBookMain(firstName, lastName, address, city, state, pin, phNumber);
			
			//Displaying the details
			System.out.println("Details Added. \n");
			System.out.println("Name: " + person.firstName + " " + person.lastName);
			System.out.println("Address: " + person.address + ", " + person.city + ", "+ person.state + " - " + person.pin);
			System.out.println("Contact Number: " + person.phNumber + "\n");
						
		}// end of for
		sc.close();
	}

}
