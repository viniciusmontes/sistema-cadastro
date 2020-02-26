package domain.exception;

public class LogradouroException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6673660268189274058L;

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
