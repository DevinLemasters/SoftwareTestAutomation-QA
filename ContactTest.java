package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {

	//Test for creating a contact. Should throw no errors.
	@Test
	void testContactCreation() {
		Contact testContact = new Contact("1", "John", "Doe", "1234567810", "123 My Address");
		assertTrue(testContact.getId().equals("1"));
		assertTrue(testContact.getFirstName().equals("John"));
		assertTrue(testContact.getLastName().equals("Doe"));
		assertTrue(testContact.getPhoneNumber().equals("1234567810"));
		assertTrue(testContact.getAddress().equals("123 My Address"));
	}
	
	//Test for creating a contact with invalid ID. Should throw errors.
	@Test
	void testInvalidID() {
		//Testing with null input for ID.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact(null, "John", "Doe", "1234567810", "123 My Address");
			});
		
		//Testing with invalid length of characters for ID.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("01234567891", "John", "Doe", "1234567810", "123 My Address");
			});
		
	}
	
	//Test for creating a contact with invalid first name. Should throw errors.
	@Test
	void testInvalidFirstName() {

		//Testing with null input for first name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("1", null, "Doe", "1234567810", "123 My Address");
			});
		
		//Testing with invalid length of characters for first name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("1", "NameTooLong", "Doe", "1234567810", "123 My Address");
			});
	}
	
	
	//Test for creating a contact with invalid last name. Should throw errors.
	@Test
	void testInvalidLastName() {
		
		//Testing with null input for last name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("1", "John", null, "1234567810", "123 My Address");
			});
		
		//Testing with invalid length of characters for last name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("1", "John", "NameTooLong", "1234567810", "123 My Address");
			});
	}
	
	//Test for creating a contact with invalid phone number. Should throw errors.
	@Test
	void testInvalidPhoneNumber() {
		
		//Testing with null input for phone number.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("1", "John", "Doe", null, "123 My Address");
			});
		
		
		//Testing with invalid length of characters for phone number.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("1", "John", "Doe", "12345678100", "123 My Address");
			});
	}

	//Test for creating a contact with invalid address. Should throw errors.
	@Test
	void testInvalidAddress() {
		
		//Testing with null input for address.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("1", "John", "Doe", "1234567810", null);
			});
		
		//Testing with invalid length of characters for address.
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			new Contact("1", "John", "Doe", "1234567810", "123 My Address is way too Longg");
			});
	}
}
