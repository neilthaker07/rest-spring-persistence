package edu.sjsu.cmpe275.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.rest.model.Address;
import edu.sjsu.cmpe275.rest.model.Sponsor;
import edu.sjsu.cmpe275.rest.service.SponsorService;

/**
 * Web Services for the Sponsor
 * @author Afreen Patel
 *
 */
@RestController
public class SponsorResource {
	
	@Autowired
	SponsorService sponsorService;

	/**
	 * Saves the Sponsor information in the database 
	 * @param name
	 * @param description
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @return Sponsor
	 */
	@RequestMapping(method=RequestMethod.POST, value="/sponsor")
	public Sponsor addSponsor(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip)
	{

		Address address = new Address(street, city, state, zip);
		Sponsor sponsor = new Sponsor(name, description);
		sponsor.setAddress(address);
		
		sponsorService.saveSponsor(sponsor);
		
		return sponsor;
	}
	
	/**
	 * Fetches the sponsor record from the database
	 * @param id
	 * @return Sponsor
	 */
	@RequestMapping("/sponsor/{id}")
	public Sponsor getSponsor(@PathVariable Long id)
	{
		Sponsor sponsor = sponsorService.findSponsorById(id);
		return sponsor;
	}
	
	/** 
	 * Updates the Sponsor record in the database
	 * @param id
	 * @param name
	 * @param description
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @return Sponsor
	 */
	@RequestMapping(method=RequestMethod.POST, value="/sponsor/{id}")
	public Sponsor updateSponsor(@PathVariable Long id,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "zip", required = false) String zip)
	{
		Sponsor sponsor = sponsorService.findSponsorById(id);
		
		Address address = new Address(street, city, state, zip);
		sponsor.setName(name);
		sponsor.setDescription(description);
		sponsor.setAddress(address);
		
		sponsorService.saveSponsor(sponsor);
		
		return sponsor;
	}
	
	/**
	 * Removes the sponsor record from the database
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/sponsor/{id}")
	public Sponsor deleteSponsor(@PathVariable Long id)
	{
		Sponsor sponsor = sponsorService.findSponsorById(id);
		sponsorService.deleteSponsorEntity(sponsor);
		
		return sponsor;
	}

}
