package bridgelabzPractice;

public class Practicce {
	
	//Class members
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String pin;
	private String phNumber;
	
	//Constructor
	public Practicce(String firstName, String lastName, String address, String city, String state, String pin, String phNumber)
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

	}

}
