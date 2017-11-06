package edu.sjsu.cmpe275.rest.resource;

import java.util.List;

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
	
	@RequestMapping("/players")
	public List<Player> getAllPlayers()
	{
		return playerRepository.findAll();
	}
	
	@RequestMapping("/players/{id}")
	public Player getPlayer(@PathVariable Long id)
	{
		return playerRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/players")
	public List<Player> addPlayer(@RequestBody final Player player)
	{
		playerRepository.save(player);
		return playerRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/players/{id}")
	public void updatePlayer(@RequestBody Player player, @PathVariable Long id)
	{
		playerRepository.save(player);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/players/{id}")
	public void deletePlayer(@PathVariable Long id)
	{
		playerRepository.delete(id);
	}
	
}
