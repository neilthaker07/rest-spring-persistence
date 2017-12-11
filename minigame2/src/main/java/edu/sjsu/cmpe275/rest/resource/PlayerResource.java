package edu.sjsu.cmpe275.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.rest.model.Address;
import edu.sjsu.cmpe275.rest.model.Player;
import edu.sjsu.cmpe275.rest.model.Sponsor;
import edu.sjsu.cmpe275.rest.service.PlayerService;
import edu.sjsu.cmpe275.rest.service.SponsorService;

/**
 * @author Neil Thaker
 * Web services for the Player
 */
@RestController
public class PlayerResource {
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	SponsorService sponsorService;

	/**
	 * Creates a new player with provided parameters
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param description
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param sponsorId
	 * @return Player
	 */
	@Transactional
	@RequestMapping(method=RequestMethod.POST, value="/player")
	public Player addPlayer(
			@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip,
			@RequestParam(value = "sponsor", required = false) Long sponsorId
			)
	{	
		playerService.isUniqueEmailAddress(email);
		
		Player player = null;
		player = new Player(firstname, lastname, email, description);
	
		if(sponsorId != null)
		{
			Sponsor sponsor = sponsorService.findSponsorById(sponsorId);
			player.setSponsor(sponsor);
		}
		
		Address address = new Address(street, city, state, zip);
		player.setAddress(address);
		
		playerService.savePlayer(player);
		
		return player;
	}
	

	/**
	 * Returns the matching player record from the database
	 * @param id
	 * @return Player
	 */
	@Transactional
	@RequestMapping(method = RequestMethod.GET, value="/player/{id}")
	public Player getPlayer(@PathVariable Long id)
	{	
		Player player = playerService.findPlayerById(id);	
		return player;	
	}
	
	
	/**
	 * Updates the Player record in the database
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param description
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param sponsorId
	 * @return Player
	 */
	@Transactional
	@RequestMapping(method=RequestMethod.POST, value="/player/{id}")
	public Player updatePlayer(@PathVariable Long id,
			@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip,
			@RequestParam(value = "sponsor", required = false) Long sponsorId)
	{
		Player player = playerService.findPlayerById(id);
		
		if(!player.getEmail().equals(email)){
			playerService.isUniqueEmailAddress(email);
		}
		
		if(sponsorId!=null)
		{
			Sponsor sponsor = sponsorService.findSponsorById(sponsorId);
			player.setSponsor(sponsor);
		}
		Address address = new Address(street, city, state, zip);

		player.setAddress(address);
		player.setFirstname(firstname);
		player.setLastname(lastname);
		player.setEmail(email);
		player.setDescription(description);
		
		playerService.savePlayer(player);
		
		return player;
	}
	
	
	/**
	 * Removes the player from the database
	 * @param id
	 */
	@Transactional
	@RequestMapping(method=RequestMethod.DELETE, value="/player/{id}")
	public Player deletePlayer(@PathVariable Long id)
	{
		Player player = playerService.findPlayerById(id);
		playerService.deletePlayerById(id);
		
		return player;
	}
}
