package edu.sjsu.cmpe275.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.rest.service.OpponentService;

/**
 * Web services for the Opponent
 * @author Purvesh Kothari
 */
@RestController
public class OpponentResource {
	
	@Autowired
	OpponentService opponentService;
	
	/**
	 * Adds the opponent to the database
	 * @param id1
	 * @param id2
	 * @return Response
	 */
	@Transactional
	@RequestMapping(method=RequestMethod.PUT, value="/opponents/{id1}/{id2}")
	public String addOpponents(@PathVariable long id1, @PathVariable long id2){
		
		String response = opponentService.makePlayersOpponents(id1, id2);
		return response;	
	}
	
	/**
	 * Removes the opponents from the database. If no relationship found, gives 404 Not Found
	 * @param id1
	 * @param id2
	 * @return Response
	 */
	@Transactional
	@RequestMapping(method=RequestMethod.DELETE, value="/opponents/{id1}/{id2}")
	public String removeOpponents(@PathVariable long id1, @PathVariable long id2){
		
		String response = opponentService.removeOpponents(id1, id2);
		return response;
	}
}
