package addressbook;

import addressbook.exceptions.ContactNotFoundException;
import addressbook.exceptions.DuplicateContactException;

public class Employee {
    private String name;
    private static AddressBook addressBook;

    public Employee(String name) {
        this.name = name;
        this.addressBook = new AddressBookImpl();
    }

    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        AddContactThread addThread = new AddContactThread(contact);
        addThread.start();
    }

 
    public void deleteContact(Contact contact) {
        try {
			addressBook.removeContact(contact);
		} catch (ContactNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (contact != null) {
            try {
				addressBook.removeContact(contact);
			} catch (ContactNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void printContacts() {
        System.out.println("Contacts for " + name + ":");
        for (Contact contact : addressBook.getAllContacts()) {
            System.out.println(contact.getName() + ", " + contact.getPhoneNumber());
        }
    }
    
    //inner class
    private static class AddContactThread extends Thread {
        private Contact contact;

        public AddContactThread(Contact contact) {
            this.contact = contact;
        }

        @Override
        public void run() {
            try {
            	addressBook.addContact(contact);
                System.out.println("Contact added asynchronously: " + contact.getName() + ", " + contact.getPhoneNumber());
            } catch (DuplicateContactException e) {
                System.out.println("Error adding contact asynchronously: " + e.getMessage());
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        // Create an Employee
        Employee employee = new Employee("John Doe");

        
     // Create and start the threads
        Thread thread1 = new AddContactThread(new Contact("Alice", "1234567890"));
        Thread thread2 = new AddContactThread(new Contact("Bob", "9876543210"));
        thread1.start();
        thread2.start();

        // Wait for the threads to finish before printing the contacts
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        // Print all contacts after deletion
        employee.printContacts();
    }

}


