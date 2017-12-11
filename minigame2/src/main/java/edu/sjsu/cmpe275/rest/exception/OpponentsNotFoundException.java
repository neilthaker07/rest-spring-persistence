package edu.sjsu.cmpe275.rest.exception;

/**
 * Exception when two players are not opponents
 * @author Purvesh Kothari
 *
 */
public class OpponentsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public String getMessage(){
    	return "These players are not opponents.";
    }

}
