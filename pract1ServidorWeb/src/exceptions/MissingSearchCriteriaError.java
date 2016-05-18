package exceptions;

public class MissingSearchCriteriaError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MissingSearchCriteriaError(){
		super("Es necessari indicar almenys un criteri de busqueda.");
	}

}
