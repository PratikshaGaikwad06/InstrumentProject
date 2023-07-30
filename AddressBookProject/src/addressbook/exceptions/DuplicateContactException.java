package addressbook.exceptions;

public class DuplicateContactException extends Exception {
	public DuplicateContactException(String message) {
        super(message);
    }
}
