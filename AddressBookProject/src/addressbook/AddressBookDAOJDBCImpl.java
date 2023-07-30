package addressbook;
import java.sql.Connection;
import java.sql.DriverManager; // all methods throws SQLException
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import addressbook.exceptions.ContactNotFoundException;

public class AddressBookDAOJDBCImpl  implements AddressBookDAO {
	public static void main(String[] args) {
		
		try {
			System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver loaded....");
		
			System.out.println("Trying to connect....");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Connected : "+ conn);
			
			ArrayList<Contact> contactsToWrite = new ArrayList<>();
	        contactsToWrite.add(new Contact("Alice", "9588474558"));
	        contactsToWrite.add(new Contact("Bob", "9876543210"));
	        
	        AddressBookDAOJDBCImpl addressBookDAO = new AddressBookDAOJDBCImpl();
	        addressBookDAO.writeContacts(contactsToWrite);
	        addressBookDAO.readContacts();
			
	        //6. close the statement, and connection
			conn.close();
			System.out.println("Disconnected from the database....");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
    public ArrayList<Contact> readContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
        	Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MYADDRESSBOOK");

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String phoneNumber = resultSet.getString("PHONENUMBER");
                Contact contact = new Contact(name, phoneNumber);
                contacts.add(contact);
            }
            System.out.println("Contacts :" + contacts);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

	@Override
    public void writeContacts(ArrayList<Contact> contacts) {
        try {
        	Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate("DELETE FROM MYADDRESSBOOK");
            for (Contact contact : contacts) {
                String name = contact.getName();
                String phoneNumber = contact.getPhoneNumber();
                PreparedStatement pst = connection.prepareStatement("INSERT INTO MYADDRESSBOOK VALUES (?,?)");
    			
    			pst.setString(1, name);
    			pst.setString(2, phoneNumber);
    			int rows = pst.executeUpdate();
    			
            
            }
            System.out.println("Rows inserted successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void updateContactName(Contact contactToUpdate, String newName) throws ContactNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContactPhoneNumber(Contact contactToUpdate, String newPhoneNumber)
			throws ContactNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact(Contact contact) throws ContactNotFoundException {
		// TODO Auto-generated method stub
		
	}
}
