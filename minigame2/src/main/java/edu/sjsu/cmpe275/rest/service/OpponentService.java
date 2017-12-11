package edu.sjsu.cmpe275.rest.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.rest.exception.OpponentsNotFoundException;
import edu.sjsu.cmpe275.rest.model.Player;

/**
 * Service layer for the Opponent model to access DAO layer
 * @author Purvesh Kothari
 *
 */
@Component
public class OpponentService {
	
	@Autowired
	PlayerService playerService;
	
	/**
	 * Makes the players opponent. Does nothing if players are already opponents
	 * @param id1
	 * @param id2
	 * @return
	 */
	@Transactional
	public String makePlayersOpponents(long id1, long id2){
		
		Player player1 = playerService.findPlayerById(id1);
		Player player2 = playerService.findPlayerById(id2);
		
		String response = "";
		
		// Saving the record in the database if no existing relationship found
		Set<Player> playerOneOpponents = player1.getOpponents();
		
		if(!playerOneOpponents.contains(player2)) {
			playerOneOpponents.add(player2);
			player1.setOpponents(playerOneOpponents);
			
			playerService.savePlayer(player1);
		}
		
		Set<Player> playerTwoOpponents = player2.getOpponents();
		
		if(!playerTwoOpponents.contains(player1)) {
			playerTwoOpponents.add(player1);
			player2.setOpponents(playerTwoOpponents);
			
			playerService.savePlayer(player2);
		}
			
		response = "Opponents successfully added to the game.";
		
		return response;
	}
	
	/**
	 * Removes the relationship between the players as opponents.
	 * @param id1
	 * @param id2
	 * @return
	 */
	@Transactional
	public String removeOpponents(long id1, long id2){
		
		Player player1 = playerService.findPlayerById(id1);
		Player player2 = playerService.findPlayerById(id2);
		
		Set<Player> playerOneOpponents = player1.getOpponents();
		
		String response = "";
		boolean isExistingOpponents = false;
		
		for(Player opponent: playerOneOpponents){
			
			if(opponent.getId() == player2.getId()){
				playerOneOpponents.remove(opponent);
				player2.getOpponents().remove(player1);
				
				response = "Opponents successfully removed.";
				isExistingOpponents = true;
				
				break;
			}
		}
		
		if(!isExistingOpponents){
			throw new OpponentsNotFoundException();
		} else {
			player1.setOpponents(playerOneOpponents);
		}
		
		playerService.savePlayer(player1);
		playerService.savePlayer(player2);
		
		return response;
	}

}
