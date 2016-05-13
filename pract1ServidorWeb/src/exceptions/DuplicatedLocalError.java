package exceptions;

public class DuplicatedLocalError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicatedLocalError(){
		super("Duplicated local.");
	}

}
