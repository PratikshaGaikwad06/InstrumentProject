package addressbook;

import java.util.ArrayList;

import addressbook.exceptions.ContactNotFoundException;

public interface AddressBookDAO {
    ArrayList<Contact> readContacts();
    void writeContacts(ArrayList<Contact> contacts);
    void updateContactName(Contact contactToUpdate, String newName) throws ContactNotFoundException;
    void updateContactPhoneNumber(Contact contactToUpdate, String newPhoneNumber) throws ContactNotFoundException;
    void deleteContact(Contact contact) throws ContactNotFoundException;
}
