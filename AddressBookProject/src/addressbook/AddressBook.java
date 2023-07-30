package addressbook;

import java.util.ArrayList;

import addressbook.exceptions.ContactNotFoundException;
import addressbook.exceptions.DuplicateContactException;

public interface AddressBook {
	void addContact(Contact contact) throws DuplicateContactException;
    void removeContact(Contact contact) throws ContactNotFoundException;
    ArrayList<Contact> getAllContacts();
    void updateContactName(Contact contactToUpdate, String newName) throws ContactNotFoundException;
    void updateContactPhoneNumber(Contact contactToUpdate, String newPhoneNumber) throws ContactNotFoundException;
    void saveToFile();
    void loadFromFile();
}
