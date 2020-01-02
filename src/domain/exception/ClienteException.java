package domain.exception;

public class ClienteException extends Exception {
	
	public ClienteException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ClienteException(String message) {
		super (message);
	}
	
	public ClienteException(Throwable cause) {
		super (cause);
	}

}
