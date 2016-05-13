package exceptions;

public class WrongAddressError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongAddressError(){
		super("The address is not valid.");
	}

}
