package main;

public class Contact {
	
	//Declare local variables.
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	//Constructor.
	public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
	}
	
	//Start Mutators Section  
	
	//Method to set the ID.
	private void setId(String id) {
		//Checks to make sure new ID meets requirements.
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("ID is invalid!");
		}
		this.id = id;
	}
	
	//Method to set the first name.
	public void setFirstName(String firstName) {
		//Checks to make sure new name meets requirements.
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First name is invalid!");
		}
		this.firstName = firstName;
	}
	
	//Method to set the last name
	public void setLastName(String lastName) {
		//Checks to make sure new name meets requirements.
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last name is invalid!");
		}
		this.lastName = lastName;
	}
	
	//Method to set the phone number.
	public void setPhoneNumber(String phoneNumber) {
		//Checks to make sure new number meets requirements.
		if (phoneNumber == null || phoneNumber.length() > 10) {
			throw new IllegalArgumentException("Phone Number is invalid!");
		}
		this.phoneNumber = phoneNumber;
	}
	
	//Method to set the address.
	public void setAddress(String address) {
		//Checks to make sure new address meets requirements.
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address is invalid!");
		}
		this.address = address;
	}
	
	
	//Start Accessors Section.
	
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}

}
