package domain.exception;

public class BairroException extends Exception {

	public BairroException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public BairroException(String message) {
		super(message);
	}
	
	public BairroException(Throwable cause) {
		super(cause);
	}
	
}
