package edu.sjsu.cmpe275.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.rest.model.Sponsor;
import edu.sjsu.cmpe275.rest.repository.SponsorRepository;

@RestController
public class SponsorResource {
	
	@Autowired
	SponsorRepository sponsorRepository;
	
	// (5) Create an sponsor
	@RequestMapping(method=RequestMethod.POST, value="/sponsor")
	public Sponsor addSponsor(@RequestBody Sponsor sponsor)
	{
		sponsorRepository.save(sponsor);
		return sponsor;
	}
	
	// (6) Get a sponsor
	@RequestMapping("/sponsor/{id}")
	public Sponsor getSponsor(@PathVariable Long id)
	{
		return sponsorRepository.findOne(id);
	}
	
	// (7) Update a sponsor
	@RequestMapping(method=RequestMethod.PUT, value="/sponsor/{id}")
	public void updateSponsor(@RequestBody Sponsor sponsor, @PathVariable Long id)
	{
		sponsorRepository.save(sponsor);
	}
	
	// (8) Delete a sponsor
	@RequestMapping(method=RequestMethod.DELETE, value="/sponsor/{id}")
	public void deleteSponsor(@PathVariable Long id)
	{
		sponsorRepository.delete(id);
	}

}
