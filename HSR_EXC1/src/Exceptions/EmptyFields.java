package Exceptions;

public class EmptyFields extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyFields() {
		super("you have to full all the fields :(");
		// TODO Auto-generated constructor stub
	}

	public EmptyFields(String message) {
		super("you have to full all the fields :("+message);
		// TODO Auto-generated constructor stub
	} 
	

	
}
