package edu.sjsu.cmpe275.rest.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.sjsu.cmpe275.rest.exception.NonuniqueEmailException;
import edu.sjsu.cmpe275.rest.exception.OpponentsNotFoundException;
import edu.sjsu.cmpe275.rest.exception.PlayerNotFoundException;
import edu.sjsu.cmpe275.rest.exception.SponsorNotFoundException;
import edu.sjsu.cmpe275.rest.exception.SponsorNotReleasedException;

/**
 * Spring boot exception handler to set appropriate response header
 * @author Purvesh Kothari
 * @author Neil Thaker
 * @author Afreen Patel
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
    /**
     * Handling PlayerNotFoundExecption with Response status 404
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {PlayerNotFoundException.class})
    @ResponseBody
    public ResponseEntity<Object> handlePlayerNotFoundException(PlayerNotFoundException ex, 
    		WebRequest request) {
    	
    	return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    /**
     * Handling OpponentsNotFoundException with Response status 404
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {OpponentsNotFoundException.class})
    @ResponseBody
    public ResponseEntity<Object> handleOpponentsNotFoundException(OpponentsNotFoundException ex, 
    		WebRequest request) {
    	
    	return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handling SponsorNotFoundExcption with Response Status 404
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {SponsorNotFoundException.class})
    @ResponseBody
    public ResponseEntity<Object> handleSponsorNotFoundException(SponsorNotFoundException ex, 
    		WebRequest request) {
    	
    	return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    /**
     * Handling NonUniqueEmailException with Response Status 400
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {NonuniqueEmailException.class})
    @ResponseBody
    public ResponseEntity<Object> handleNonuniqueEmailException(NonuniqueEmailException ex, 
    		WebRequest request) {
    	
    	return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Handling SponsorNotReleasedException with Response Status 400
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {SponsorNotReleasedException.class})
    @ResponseBody
    public ResponseEntity<Object> handleSponsorNotReleasedException(SponsorNotReleasedException ex, 
    		WebRequest request) {
    	
    	return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    
}
