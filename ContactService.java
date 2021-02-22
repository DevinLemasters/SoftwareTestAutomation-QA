package main;
import java.util.ArrayList;

public class ContactService {
	
	//Create vector for storing contact list.
	private ArrayList<Contact> contactList = new ArrayList<>();
	
	//Create a variable for assigning a unique ID.
	private int uniqueId = 0;
	
	//Method for adding a new contact to the contact list.
	public void addContact(String firstName, String lastName, String phoneNumber, String address) {
		
		//Generate a unique contact identifier based off the size of the contact list.
		String id = Integer.toString(uniqueId);
		
		//Increment uniqueId so next contact has a different ID.
		uniqueId++;
		
		//Generate new contact with information.
		Contact newContact = new Contact(id, firstName, lastName, phoneNumber, address);
		
		//Adds newly created contact to contact list.
		contactList.add(newContact);
	}
	
	//Method for deleting a contact from the contact list.
	public void deleteContact(String id) {
		
		//Checks to make sure there are contacts in the list.
		if (contactList.size() == 0) {
			throw new Error("Contact list is empty");
		}
		
		//For loop to search for contact by ID.
		for (int i = 0; i < contactList.size(); i++) {
			
			//Removes contact if ID is found.
			if (contactList.get(i).getId().equals(id)) {
				contactList.remove(i);
				
				//Return from method once contact is removed.
				return;
			}
		}
		//Throws error if ID was not found.
		throw new Error("ID was not found");
	}
	
	public void updateContact(String id, String firstName, String lastName, String phoneNumber, String address) {
		
		//Checks for empty contact list.
		if (contactList.size() == 0) {
			throw new Error("Contact list is empty");
		}
		
		//For loop to search for contact by ID.
		for (int i = 0; i < contactList.size(); i++) {
			
			//Updates contact if ID is found.
			if (contactList.get(i).getId().equals(id)) {
				
				contactList.get(i).setFirstName(firstName);;
				contactList.get(i).setLastName(lastName);
				contactList.get(i).setPhoneNumber(phoneNumber);
				contactList.get(i).setAddress(address);
				
				//Return from method once contact is updated.
				return;
			}
		}
		
		//Could not find contact to update. Throw error.
		throw new Error("Contact not found!");
	}
}
