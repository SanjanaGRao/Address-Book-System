package bridgelabzPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*
;public class AddressBookMain {

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
			if(duplicateCheck(firstName) == false)
			{
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
			}
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
					contact.displayAddressBook();
					System.out.println("Enter the number of the detail you want to edit \n1.First Name\n2.Last Name\n3.Address\n4.City\n"
							+ "5.State\n6.PIN Code\n7.Contact Number\n8.Email ID");
	                int choose = sc.nextInt();
	                switch(choose)
	                {
	                case 1: {
	                	System.out.println("Enter your first name: ");
	                	contact.firstName = sc.next();
	                	break;
	                	}
	                case 2: {
	                	System.out.println("Enter your last name: ");
						contact.lastName = sc.next();
						break;
	                }
	                case 3: {
	                	System.out.println("Enter your Address: ");
						contact.address = sc.next();
						break;
	                }
	                case 4: {
	                	System.out.println("Enter your city: ");
						contact.city = sc.next();
						break;
	                }
	                case 5: {
	                	System.out.println("Enter your state: ");
						contact.state = sc.next();
						break;
	                }
	                case 6: {
	                	System.out.println("Enter your city PIN Code: ");
						contact.pin = sc.next();
						break;
	                }
	                case 7: {
	                	System.out.println("Enter your contact number: ");
						contact.phNumber = sc.next();
						break;
	                }
	                case 8: {	
	                	System.out.println("Enter your contact number: ");
						contact.phNumber = sc.next();
						break;
	                }
	                default: System.out.println("Invalid.");
	               }
				}// end of if
				else
					System.out.println("Contact not found.");
			}// end of for
		}
		
		//Function to delete a contact-UC4
		public void deleteContact()
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
				else
					System.out.println("Contact not found.");
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
		
		//Method to check for duplicate contacts
		public Boolean duplicateCheck(String name)
		{
		    for (int j=0; j<person1.size(); j++)
	        {   
	            AddressBookMain object = person1.get(j);
	            if(object.firstName.equals(name))
	            {
	                System.out.println("Contact already exists in this Address Book."); 
	                return true;
	            }
	        }
		    return false;
		}
		
		//Method to search the contact based on person's city or state
		public void searchContact(String place) 
		 {
		        for (int j=0;j<person1.size();j++)
		        {   
		            AddressBookMain contact = person1.get(j);
		            if(contact.city.equals(place)||contact.state.equals(place))
		            {
		                contact.displayAddressBook();  
		            }
		        }		        
		 }
		
		//Method to view a particular contact based on city
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public void viewPersonByCity()
	    {
	        Map<String,List<String>> cityMap = new HashMap<> ();
	        for (int j=0;j<person1.size();j++)
	        {   
	            AddressBookMain object=person1.get(j);
	            if(cityMap.containsKey(object.city))
	            {
	                List<String> temp= cityMap.get(object.city);
	                temp.add(object.firstName);
	                cityMap.put(object.city, temp);
	            }
	            else
	            {
	                List<String> temp=new ArrayList<>();
	                temp.add(object.firstName);
	                cityMap.put(object.city, temp);
	            }
	        }
	        for(Map.Entry m: cityMap.entrySet()) 
	        {
	           System.out.println(m.getKey()+" : "+m.getValue());  
	           System.out.println("There are "+((List<String>) m.getValue()).size()+" people in City "+m.getKey());
	        }
	    }
	    
		// Method to view a particular contact based on state
	    @SuppressWarnings({ "unchecked", "rawtypes" }) //added this because it was a warning suggestion
		public void viewPersonByState() 
	    {
	        Map<String,List<String>> stateMap = new HashMap<> ();
	        for (int j=0;j<person1.size();j++)
	        {   
	            AddressBookMain object=person1.get(j);
	            if(stateMap.containsKey(object.state))
	            {
	                List<String> temp= stateMap.get(object.state);
	                temp.add(object.firstName);
	                stateMap.put(object.state, temp);
	            }
	            else
	            {
	                List<String> temp=new ArrayList<>();
	                temp.add(object.firstName);
	                stateMap.put(object.state, temp);
	            }
	        }
	        for(Map.Entry m: stateMap.entrySet()) 
	        {
	          System.out.println(m.getKey()+" : "+m.getValue()); 
	          System.out.println("There are "+((List<String>) m.getValue()).size()+" people in state "+m.getKey());
	        }
	   } 
	    /*
	     * method to sort the list based on name or city or state or zip
	     */
	    
	    public void sortPersonByNameCityStateZip(int option){

	        Map<String,List<AddressBookMain>> map = new HashMap<> ();
	        if(option == 1) 
	        {
	            for (int j=0;j<person1.size();j++)
	            {   
	                AddressBookMain object=person1.get(j);
	                if(map.containsKey(object.firstName))
	                {
	                    List<AddressBookMain> temp= map.get(object.firstName);
	                    temp.add(object);
	                    map.put(object.firstName, temp);
	                }
	                else
	                {
	                    List<AddressBookMain> temp=new ArrayList<>();
	                    temp.add(object);
	                    map.put(object.firstName, temp);
	                }
	            }
	        }
	        else if(option == 2) 
	        {
	            for (int j=0;j<person1.size();j++)
	            {   
	                AddressBookMain object=person1.get(j);
	                if(map.containsKey(object.city))
	                {
	                    List<AddressBookMain> temp= map.get(object.city);
	                    temp.add(object);
	                    map.put(object.city, temp);
	                }
	                else
	                {
	                    List<AddressBookMain> temp=new ArrayList<>();
	                    temp.add(object);
	                    map.put(object.city, temp);
	                }
	            }
	        }
	        else if(option == 3) 
	        {
	            for (int j=0;j<person1.size();j++)
	            {   
	                AddressBookMain object=person1.get(j);
	                if(map.containsKey(object.state))
	                {
	                    List<AddressBookMain> temp= map.get(object.state);
	                    temp.add(object);
	                    map.put(object.state, temp);
	                }
	                else
	                {
	                    List<AddressBookMain> temp=new ArrayList<>();
	                    temp.add(object);
	                    map.put(object.state, temp);
	                }
	            }
	        }
	        else if(option == 4) 
	        {
	            for (int j=0;j<person1.size();j++)
	            {   
	                AddressBookMain object=person1.get(j);
	                if(map.containsKey(object.pin))
	                {
	                    List<AddressBookMain> temp= map.get(object.pin);
	                    temp.add(object);
	                    map.put(object.pin, temp);
	                }
	                else
	                {
	                    List<AddressBookMain> temp=new ArrayList<>();
	                    temp.add(object);
	                    map.put(object.pin, temp);
	                }
	            }
	        }
	        else {
	            System.out.println("choose correct option");
	        }
	        Map<String, List<AddressBookMain>> sortedMap = map.entrySet().stream()
	                .sorted(Map.Entry.comparingByKey())
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue,LinkedHashMap::new));
	        for (Map.Entry<String, List<AddressBookMain>> entry : sortedMap.entrySet()) {
	            for(AddressBookMain a: entry.getValue()) {
	                System.out.println("First Name:"+a.firstName);
	                System.out.println("Last Name:"+a.lastName);
	                System.out.println("Address:"+a.address);
	                System.out.println("City:"+a.city);
	                System.out.println("State:"+a.state);
	                System.out.println("Zip:"+a.pin);
	                System.out.println("Phone number:"+a.phNumber);
	                System.out.println("E-mail:"+a.email);
	                System.out.println("--------------------------------------------");
	            }
	        }
	    }
	    
	    /*
	     * Method writeFile writes into the file the contact details of the person
	     * IO exceptions are handled.
	     */
	    public void writeFile(String file) 
	    {
	        try 
	        {
	            FileWriter writer = new FileWriter(file+".txt");
	            for (int j=0;j<person1.size();j++)
	            {
	                AddressBookMain object=person1.get(j);
	                writer.write("\nFirst Name:"+object.firstName+"\nLast Name:"+object.lastName+
	                        "\nAddress:"+object.address+"\nCity:"+object.city+"\nState:"+object.state
	                        +"\nPIN:"+object.pin+"\nContact number:"+object.phNumber+"\nEmail ID:"
	                        +object.email+"\n");
	            }
	            writer.close();
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	        }    
	    }
	    
	    /*
	     * Method readFile reads into the file the contact details of the person
	     * IO exceptions are handled.
	     */
	    public void readFile(String file) throws IOException
	    {
	        FileReader fr =new FileReader(file+".txt");
	              int i;
	              while ((i=fr.read()) != -1)
	                System.out.print((char) i);
	    }
}
