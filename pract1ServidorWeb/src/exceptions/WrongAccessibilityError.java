package exceptions;

public class WrongAccessibilityError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongAccessibilityError(){
		super("Wrong accessibility report. Doesn't match with type local.");
	}

}
