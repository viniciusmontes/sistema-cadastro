package domain.exception;

public class LogradouroException extends Exception {
	
	public LogradouroException(String menssage, Throwable cause) {
		super (menssage, cause);
	}
	
	public LogradouroException(String menssage) {
		super(menssage);
	}
	
	public LogradouroException(Throwable cause) {
		super(cause);
	}


}
