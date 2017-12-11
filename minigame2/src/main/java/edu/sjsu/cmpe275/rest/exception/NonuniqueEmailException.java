package edu.sjsu.cmpe275.rest.exception;

/**
 * Exception for handling duplicate email address
 * @author Afreen Patel
 *
 */
public class NonuniqueEmailException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public String getMessage(){
    	return "Player email address must be unique.";
    }
}
