package edu.sjsu.cmpe275.rest.exception;

/**
 * Exception when sponsor with given id is not found
 * @author Neil Thaker
 *
 */
public class SponsorNotFoundException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	private final Long id;

    public SponsorNotFoundException(Long id) {
        this.id = id;
    }

    public String getMessage(){
    	return "Sponsor with ID " + this.id + " does not exist.";
    }
}
