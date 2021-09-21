package bridgelabzPractice;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MultipleAddressBook {

	public static  int k = 0;//to iterate the program many times
	public static Scanner sc = new Scanner(System.in);
	
	/*
	 * Method to perform different operations on contacts
	 * @param 'choice' refers to user's input i.e.,the operations the user wants to perform on addressbook
	 */
	public static  void choiceOfUser(int choice, AddressBookMain person)
	{
			switch(choice)
			{
			case 2:	person.insertContact();//To add a new contact into addressbook
					break;
			
			case 3: person.editContact();//To edit existing contact							
					break;
				   
			case 4: person.deleteContact();	//To delete the existing contact
					break;
					
			case 5: person.displayAddressBook();//To display whole addressbook
					break;	
					
			default: System.out.println("Invalid option"); 
					 break;
					
			}
	}
			
			public static void main(String[] args) throws IOException {

				Hashtable<String,AddressBookMain>  multipleAddressBook = new Hashtable<>();  //dictionary for mapping different address book with key 
				AddressBookMain person = new AddressBookMain();	//first addressbook				
				int choice = 0;
				String n="";
				String y= "AddressBook1" ;
				multipleAddressBook.put(y, person);	//put the first addressbook into dictionary
				
				while(choice!=10) //it repeats till the user wants to end
				{
					System.out.println("Enter your choice:\n 1) Create New Address Book\n 2) Add Contact \n 3) Edit existing Contact\n "
							+ "4) Delete contact\n 5) Display Address Book\n 6) Create Another AddressBook\n 7) Search a person based on City/State\n "
							+ "8) View person by City\n 9) View person by State\n 10) Sort by Name, City, State or PIN Code\n 11)Add to file\n "
							+ "12) Read from file\n 13) Exit"); //user selection
					choice=sc.nextInt();
					switch(choice)
					{
					case 1:  //to create a new address book
						{
							System.out.println("Enter the name of the Address Book:");
							n=sc.next();
							AddressBookMain addressBook1 = new AddressBookMain();  // a new addressbook object is created 
							multipleAddressBook.put(n, addressBook1);
							break;	
						}
					case 2:
					case 3:
					case 4:
					case 5:
						{
							System.out.println("Enter the name of the AddressBook where you want to perform the operations: ");
							n=sc.next();
							choiceOfUser(choice,multipleAddressBook.get(n));   //to perform required operation on desired addressbook
							break;
						}
					case 6: 
						{
							System.out.println("Enter the name of the Address Book: ");
							n = sc.next();
							if(multipleAddressBook.containsKey(n))
							{
							    System.out.println("Address Book already exists.");
							    n=sc.next();
							}
							AddressBookMain addressBook2 = new AddressBookMain();  
							multipleAddressBook.put(n, addressBook2);
							break;
						}
					case 7:
						{
						    System.out.println("Enter the City/State: ");
						    String place=sc.next();
						    System.out.println("Person's whose State/City is: "+place);
						    for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
						    {
						        AddressBookMain addressbook3 = entry.getValue();
						        addressbook3.searchContact(place);
						    }
						    break;
						}
					case 8: {
						 for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
			                {
			                    AddressBookMain addressbook4 = entry.getValue();
			                    System.out.println("Addressbook:"+entry.getKey());
			                    addressbook4.viewPersonByCity();
			                }
						 break;
					}
					case 9: {
						for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
		                {
		                    AddressBookMain addressbook5 = entry.getValue();
		                    System.out.println("Addressbook:"+entry.getKey());
		                    addressbook5.viewPersonByState();
		                }
						break;
					}
					case 10: {
						System.out.println("Sort By: 1.Name 2.city 3.state 4.PIN Code");
		                int option = sc.nextInt(); 
						for(Map.Entry<String, AddressBookMain> entry : multipleAddressBook.entrySet())
			                {
			                    AddressBookMain object1 = entry.getValue();
			                    System.out.println("Addressbook:"+entry.getKey());
			                    object1.sortPersonByNameCityStateZip(option);
			                }
						break;
					}
					case 11:{
						System.out.println("Enter the Address book which you want to add into file: ");
		                String AddressBook=sc.next();
		                multipleAddressBook.get(AddressBook).writeFile(AddressBook);
						break;
					}
					case 12:{
						System.out.println("Enter the Address book which you want to read from file: ");
		                String AddressBook=sc.next();
		                multipleAddressBook.get(AddressBook).readFile(AddressBook);
						break;
					}
					case 13: System.exit(0);
					default: System.out.println("Enter a Valid Option.");
					}//end of switch
				}// end of while
		}
}
