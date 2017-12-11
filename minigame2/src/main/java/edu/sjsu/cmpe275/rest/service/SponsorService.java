package edu.sjsu.cmpe275.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.rest.exception.SponsorNotFoundException;
import edu.sjsu.cmpe275.rest.exception.SponsorNotReleasedException;
import edu.sjsu.cmpe275.rest.model.Player;
import edu.sjsu.cmpe275.rest.model.Sponsor;
import edu.sjsu.cmpe275.rest.repository.SponsorRepository;

/**
 * Services for the Sponsor entity to access DAO layer
 * @author Purvesh Kothari
 *
 */
@Component
public class SponsorService {
	
	@Autowired
	SponsorRepository sponsorRepository;
	
	@Autowired
	PlayerService playerService;
	
	/**
	 * Finds the Sponsor by the ID. Throws SponsorNotFoundException if no sponsor found
	 * @param sponsorId
	 * @return
	 */
	@Transactional
	public Sponsor findSponsorById(Long sponsorId){
		Sponsor sponsor = sponsorRepository.findOne(sponsorId);
		
		if(sponsor != null){
			return sponsor;
		} else {
			throw new SponsorNotFoundException(sponsorId);
		}
	}
	
	/**
	 * Persists the Sponsor record in the database
	 * @param sponsor
	 */
	@Transactional
	public void saveSponsor(Sponsor sponsor){
		sponsorRepository.save(sponsor);
	}
	
	/**
	 * Removes the Sponsor record from the database
	 * @param id
	 */
	@Transactional
	public void deleteSponsorEntity(Sponsor sponsor){
		
		List<Player> players = playerService.getPlayersBySponsor(sponsor.getId());
		
		if(players.size()>0){
			throw new SponsorNotReleasedException(sponsor.getId());
		} else{
			sponsorRepository.delete(sponsor);
		}
	}
}
