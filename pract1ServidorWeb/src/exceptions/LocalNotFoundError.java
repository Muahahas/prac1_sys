package exceptions;

public class LocalNotFoundError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LocalNotFoundError(int idLocal) {
		super("El local amb id="+idLocal+" no existeix en la base de dades del sistema.");
	}

}
