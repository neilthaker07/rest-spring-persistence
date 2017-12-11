package edu.sjsu.cmpe275.rest.exception;

/**
 * Exception when player with given id is not found
 * @author Afreen Patel
 *
 */
public class PlayerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final Long id;

    public PlayerNotFoundException(Long id) {
        this.id = id;
    }

    public String getMessage(){
    	return "Player with ID " + this.id + " does not exist.";
    }
}
