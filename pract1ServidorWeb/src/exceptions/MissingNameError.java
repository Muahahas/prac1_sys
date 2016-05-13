package exceptions;

public class MissingNameError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MissingNameError(){
		super("It's missing the name of the local.");
	}

}
