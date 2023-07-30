package addressbook;

import java.util.ArrayList;

import addressbook.exceptions.ContactNotFoundException;
import addressbook.exceptions.DuplicateContactException;

public class AddressBookImpl implements AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private static final String FILE_NAME = "data/address_book_data.txt";
    private AddressBookDAO addressBookDAO = new AddressBookDAOImpl();

    @Override
    public void addContact(Contact contact) throws DuplicateContactException {
        if (contacts.contains(contact)) {
            throw new DuplicateContactException("Contact already exists in the address book.");
        }
        contacts.add(contact);
    }

    @Override
    public void removeContact(Contact contact)  {
    	try {
			addressBookDAO.deleteContact(contact);
		} catch (ContactNotFoundException e) {
			e.printStackTrace();
		}
//        if (!contacts.contains(contact)) {
//            throw new ContactNotFoundException("Contact not found in the address book.");
//        }
        contacts.remove(contact);
    }

    @Override
    public ArrayList<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }
    
    

    @Override
    public void saveToFile() {
        addressBookDAO.writeContacts(contacts);
        System.out.println("Address book saved successfully.");
    }

    @Override
    public void loadFromFile() {
        ArrayList<Contact> loadedContacts = addressBookDAO.readContacts();
        if (loadedContacts != null) {
            contacts = loadedContacts;
            System.out.println("Address book loaded successfully.");
        }
    }

	public void updateContactName(Contact contactToUpdate, String newName) throws ContactNotFoundException {
		addressBookDAO.updateContactName(contactToUpdate, newName);
	}

	
	public void updateContactPhoneNumber(Contact contactToUpdate, String newPhoneNumber) throws ContactNotFoundException {
		addressBookDAO.updateContactPhoneNumber(contactToUpdate, newPhoneNumber);
	}

	

	
}
