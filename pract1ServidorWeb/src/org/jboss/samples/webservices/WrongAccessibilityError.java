package org.jboss.samples.webservices;

public class WrongAccessibilityError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongAccessibilityError(){
		super("Wrong Accessibility Report. Doesn't match with the type local.");
	}

}
