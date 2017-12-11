package edu.sjsu.cmpe275.rest.exception;

/** Exception when Sponsor is attempted to deleted and referenced with Player
 * @author Purvesh Kothari
 *
 */
public class SponsorNotReleasedException extends RuntimeException { 
	
	private static final long serialVersionUID = 1L;

	private long id;
	
	public SponsorNotReleasedException(long id){
		this.id = id;
	}
	
	public String getMessage(){
		return "Sponsor with ID " + this.id + " is currently referenced with players.";
	}

}
