package edu.sjsu.cmpe275.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.rest.exception.NonuniqueEmailException;
import edu.sjsu.cmpe275.rest.exception.PlayerNotFoundException;
import edu.sjsu.cmpe275.rest.model.Player;
import edu.sjsu.cmpe275.rest.repository.PlayerRepository;

/**
 * Service layer for the Player entity to access DAO layer
 * @author Purvesh Kothari
 *
 */
@Component
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;
	
	/**
	 * Validates that player exists with the given email id. Throws NonuniqueEmailException otherwise
	 * @param email
	 * @return
	 */
	@Transactional
	public boolean isUniqueEmailAddress(String email){
		
		Player player = playerRepository.findPlayerByEmailId(email);
		
		if(player == null){
			return true;
		} else{
			throw new NonuniqueEmailException();
		}
	}
	
	/**
	 * Returns the player from database, if found. Throws PlayerNotFoundException otherwise
	 * @param id
	 * @return
	 */
	@Transactional
	public Player findPlayerById(Long id){
		
		Player player = playerRepository.findOne(id);
		
		if(player != null){
			return player;
		} else {
			throw new PlayerNotFoundException(id);
		}
	}
	
	/**
	 * Returns the list of player currently associated with given sponsor id
	 * @param sponsorId
	 * @return
	 */
	@Transactional
	public List<Player> getPlayersBySponsor(Long sponsorId){
		return playerRepository.findPlayersBySponsorId(sponsorId);
	}
	
	/**
	 * Persists the Player record in the database
	 * @param player
	 * @return
	 */
	@Transactional
	public Player savePlayer(Player player){
		return playerRepository.save(player);
	}
	
	/**
	 * Removes the Player record from database
	 * @param id
	 */
	@Transactional
	public void deletePlayerById(Long id){
		playerRepository.delete(id);
	}
}
