package edu.sjsu.cmpe275.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.rest.model.Player;
import edu.sjsu.cmpe275.rest.repository.PlayerRepository;

@RestController
public class PlayerResource {

	@Autowired
	PlayerRepository playerRepository;
	/*
	@RequestMapping("/players")
	public List<Player> getAllPlayers()
	{
		return playerRepository.findAll();
	}
*/
	
	// (1) Create a player
	@RequestMapping(method=RequestMethod.POST, value="/player")
	public Player addPlayer(@RequestBody final Player player)
	{
		playerRepository.save(player);
		return player;
	}
	
	// (2) Get a player
	@RequestMapping("/player/{id}")
	public Player getPlayer(@PathVariable Long id)
	{
		return playerRepository.findOne(id);
	}
	
	// (3) Update a player
	@RequestMapping(method=RequestMethod.PUT, value="/player/{id}")
	public void updatePlayer(@RequestBody Player player, @PathVariable Long id)
	{
		playerRepository.save(player);
	}
	
	// (4) Delete a player
	@RequestMapping(method=RequestMethod.DELETE, value="/player/{id}")
	public void deletePlayer(@PathVariable Long id)
	{
		playerRepository.delete(id);
	}
	
}
