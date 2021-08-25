package bridgelabzPractice;
import java.util.Hashtable;
import java.util.Scanner;

public class MultipleAddressBook {

	public static  int k=0;//to iterate the program many times
	public static Scanner sc=new Scanner(System.in);
	
	/*Method to perform different operations on contacts
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
					
			}
	}
			
			public static void main(String[] args) {

				Hashtable<String,AddressBookMain>  multipleAddressBook = new Hashtable<String, AddressBookMain>();  //dictionary for mapping different address book with key 
				AddressBookMain person = new AddressBookMain();					//first addressbook
				
				String n="";
				String y= "AddressBook1" ;
				multipleAddressBook.put(y, person);							//put the first addressbook into dictionary
				
				while(k!=6) //it repeats till the user wants to end
				{
					System.out.println("Enter your choice\n 1) Create New Address Book\n 2) Add Contact \n 3) Edit existing Contact\n 4) Delete contact\n 5) Display Address Book\n 6) Exit"); //user selection
					int choice=sc.nextInt();
					if(choice==1)  //to create a new address book
					{
						System.out.println("Enter the name of the Address Book:");
						n=sc.next();
						AddressBookMain addressBook1 = new AddressBookMain();  // a new addressbook object is created 
						multipleAddressBook.put(n, addressBook1);
							
					}
					else
					{
						System.out.println("Enter the name of the AddressBook where you want to perform the operations: ");
						n=sc.next();
						choiceOfUser(choice,multipleAddressBook.get(n));   //to perform required operation on desired addressbook
					}				
				}// end of while
		}
}
