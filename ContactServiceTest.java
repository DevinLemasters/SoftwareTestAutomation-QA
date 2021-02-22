package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.ContactService;

class ContactServiceTest {

	//Testing adding a contact.
	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		service.addContact("John", "Doe", "1234567810", "123 My Address");
		
		//Test to make sure an invalid contact with null cannot be added.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		service.addContact(null, "Doe", "1234567810", "123 My Address");
		});
		
		//Test to make sure an invalid contact with too many characters cannot be added.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("NameTooLong", "Doe", "1234567810", "123 My Address");
			});
	}
	
	//Testing deleting a contact
	@Test
	void testDeleteContact() {
		//Create contact service.
		ContactService service = new ContactService();
		
		//Checks for empty list. Should receive error when deleting from empty list.
		Assertions.assertThrows(Error.class, () -> {
			service.deleteContact("0");
			});
		
		//Add new contact to list **Should be contact ID 0.
		service.addContact("John", "Doe", "1234567810", "123 My Address");
		
		//Checks to make sure we are unable to delete a contact that does not exist.
		Assertions.assertThrows(Error.class, () -> {
			service.deleteContact("1");
		});	
		
		//Add new contact to list **Should be contact ID 0.
		service.addContact("John", "Doe", "1234567810", "123 My Address");
		
		
		//Checks to make sure newly added contact can be deleted.
		service.deleteContact("0");
		
	}
	
	//Testing updating a contact.
	@Test
	void testUpdateContact() {
		//Create contact service.
		ContactService service = new ContactService();
		
		//Checks for empty list. Should receive error when trying to update from empty list.
		Assertions.assertThrows(Error.class, () -> {
			service.updateContact("0", "Jane", "Smith", "5555555555", "New Address");
		});
		
		//Add new contact to list.
		service.addContact("John", "Doe", "1234567810", "123 My Address");
		
		//Update the contact.
		service.updateContact("0", "Jane", "Smith", "5555555555", "New Address");
		
		//Add another new contact to list.
		service.addContact("Jane", "Doe", "1234567810", "123 My Address");
		
		//Update the contact.
		service.updateContact("1", "Jane", "Smith", "5555555555", "New Address");
		
		//Update the contact with exceeding character limit. Should throw error.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			service.updateContact("0", "NameTooLong", "Smith", "5555555555", "New Address");
		});
		
		//Update the contact with null arguments. Should throw error.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			service.updateContact("0", "Jane", null, "5555555555", "New Address");
		});
		
		//Update a contact that does not exist. Should throw error.
		assertThrows(Error.class, () -> {
			service.updateContact("2", "Jane", "Smith", "5555555555", "New Address");
		});
	}
	
	
}