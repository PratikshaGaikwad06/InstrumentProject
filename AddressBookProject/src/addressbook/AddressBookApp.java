package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

import addressbook.exceptions.ContactNotFoundException;
import addressbook.exceptions.DuplicateContactException;

public class AddressBookApp {
    private static AddressBook addressBook = new AddressBookImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addressBook.loadFromFile(); // Load data from file when the program starts

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. List Contacts");
            System.out.println("4. Save to File");
            System.out.println("5. Load from File");
            System.out.println("0. Exit");
            System.out.println("6. Update Contact");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;

                case 2:
                    removeContact();
                    break;

                case 3:
                    listContacts();
                    break;

                case 4:
                    addressBook.saveToFile();
                    break;

                case 5:
                    addressBook.loadFromFile();
                    break;
                    
                case 6:
                	updateContact();
                	 addressBook.loadFromFile();
//                	 addressBook.saveToFile();
                    break;

                case 0:
                    System.out.println("Exiting Address Book. Goodbye!");
                    scanner.close();
                    System.exit(0);

              
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter the name of the contact: ");
        scanner.nextLine(); // Consume the newline character
        String name = scanner.nextLine();
        System.out.print("Enter the phone number of the contact: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = new Contact(name, phoneNumber);
        try {
            addressBook.addContact(newContact);
            System.out.println("Contact added successfully.");
        } catch (DuplicateContactException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void updateContact() {
    	System.out.println("Enter the name or phone number of the contact to update: ");
    	scanner.nextLine();
    	 String searchKeyword = scanner.nextLine();
    	
    	Contact contactToUpdate = null;
    	for(Contact contact : addressBook.getAllContacts()) {
    		if(contact.getName().equalsIgnoreCase(searchKeyword) || contact.getPhoneNumber().equals(searchKeyword)) {
    			contactToUpdate = contact;
    			break;
    		}
    	}
    	if (contactToUpdate != null) {
    		System.out.println("Contact found. What do you want to update?");
            System.out.println("1. Name");
            System.out.println("2. Phone Number");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 
            
            switch (choice) {
	            case 1:
	                System.out.print("Enter the new name: ");
	                String newName = scanner.nextLine();
	                // Instead of using a direct setter, use a specific update method
					try {
						addressBook.updateContactName(contactToUpdate, newName);
					} catch (ContactNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	
	            case 2:
	                System.out.print("Enter the new phone number: ");
	                String newPhoneNumber = scanner.nextLine();
	                // Instead of using a direct setter, use a specific update method
					try {
						addressBook.updateContactPhoneNumber(contactToUpdate, newPhoneNumber);
					} catch (ContactNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	
	            default:
	                System.out.println("Invalid choice. No updates were made.");
	                return;
	        }

        } else {
            System.out.println("Contact not found in the address book.");
        }
    	
    }
    

    private static void removeContact() {
        System.out.print("Enter the name of the contact to remove: ");
        scanner.nextLine(); // Consume the newline character
        String nameToRemove = scanner.nextLine();
        Contact contactToRemove = null;
        for (Contact contact : addressBook.getAllContacts()) {
            if (contact.getName().equalsIgnoreCase(nameToRemove)) {
                contactToRemove = contact;
                break;
            }
        }
        if (contactToRemove != null) {
            try {
                addressBook.removeContact(contactToRemove);
                System.out.println("Contact removed successfully.");
            } catch (ContactNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Contact not found in the address book.");
        }
    }

    private static void listContacts() {
        ArrayList<Contact> contacts = addressBook.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found in the address book.");
        } else {
            System.out.println("Address Book Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
    
//    private static void updateContact() {
//        
//        if (contacts.isEmpty()) {
//            System.out.println("No contacts found in the address book.");
//        } else {
//            System.out.println("Address Book Contacts:");
//            for (Contact contact : contacts) {
//                System.out.println(contact);
//            }
//        }
//    }
}
