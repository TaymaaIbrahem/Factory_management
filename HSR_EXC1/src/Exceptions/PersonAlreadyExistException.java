package Exceptions;

import model.Person;

public class PersonAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PersonAlreadyExistException(Person p) {
		super("The person already exists in the System: " +p.getFirstName() +" " +p.getLastName()+ " The person not added to the system");	
	}
}
