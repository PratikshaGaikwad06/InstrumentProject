package addressbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import addressbook.exceptions.ContactNotFoundException;

public class AddressBookDAOImpl implements AddressBookDAO {
    private static final String FILE_NAME = "data/address_book_data.txt";

    @Override
    public ArrayList<Contact> readContacts() {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            ArrayList<Contact> contacts = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    Contact contact = new Contact(name, phoneNumber);
                    contacts.add(contact);
                }
            }
            return contacts;
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating a new address book file.");
        } catch (IOException e) {
            System.out.println("Error loading address book: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void writeContacts(ArrayList<Contact> contacts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts) {
                writer.println(contact.getName() + "," + contact.getPhoneNumber());
            }
        } catch (IOException e) {
            System.out.println("Error saving address book: " + e.getMessage());
        }
    }

	@Override
	 public void updateContactName(Contact contactToUpdate, String newName) throws ContactNotFoundException {
        ArrayList<Contact> contacts = readContacts();
        int index = -1;// = contacts.indexOf(contactToUpdate);
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(contactToUpdate.getName())) {
                index =  i; // Found the contact at index i
                break;
            }
        }
        
        if (index != -1) {
            Contact updatedContact = contacts.get(index);
            System.out.println("index : " + index + " " + "contact : " + updatedContact);
            updatedContact.setName(newName); // Set the new name using the setName method
            contacts.set(index, updatedContact);
            writeContacts(contacts);
            System.out.println("Contact name updated successfully.");
        } else {
        	throw new ContactNotFoundException("Contact not found in the address book.");
        }
    }
	
	@Override
	 public void updateContactPhoneNumber(Contact contactToUpdate, String newPhoneNumber) throws ContactNotFoundException {
       ArrayList<Contact> contacts = readContacts();
       int index = -1;// = contacts.indexOf(contactToUpdate);
       for (int i = 0; i < contacts.size(); i++) {
           if (contacts.get(i).getPhoneNumber().equals(contactToUpdate.getPhoneNumber())) {
               index =  i; // Found the contact at index i
               break;
           }
       }
       if (index != -1) {
           Contact updatedContact = contacts.get(index);
           updatedContact.setPhoneNumber(newPhoneNumber); // Set the new phone number using the setPhoneNumber method
           contacts.set(index, updatedContact);
           writeContacts(contacts);
           System.out.println("Contact phone number updated successfully.");
       } else {
       	throw new ContactNotFoundException("Contact not found in the address book.");
       }
   }

	@Override
	public void deleteContact(Contact contact) throws ContactNotFoundException{
        ArrayList<Contact> contacts = readContacts();
        if (contacts.remove(contact)) {
            writeContacts(contacts);
            System.out.println("Contact deleted successfully.");
        } else {
        	 throw new ContactNotFoundException("Contact not found in the address book.");
        }
    }
}
