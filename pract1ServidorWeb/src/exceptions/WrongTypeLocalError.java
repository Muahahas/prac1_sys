package exceptions;

public class WrongTypeLocalError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongTypeLocalError(){
		super("The selected type local doesn't exist.");
	}

}
