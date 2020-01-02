package domain.exception;

public class MunicipioException extends Exception {
	
	public MunicipioException( String message, Throwable cause) {
		super(message, cause);
	}
	
	public MunicipioException(String message) {
		super(message);
	}
	
	public MunicipioException(Throwable cause) {
		super(cause);
	}

}
