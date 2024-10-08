package Exceptions;

public class NoDataInTheSystem extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataInTheSystem() {
		super("There is no enough data !!");
		// TODO Auto-generated constructor stub
	}

	public NoDataInTheSystem(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
