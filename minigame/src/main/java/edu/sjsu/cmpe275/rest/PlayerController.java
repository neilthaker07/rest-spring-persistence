package edu.sjsu.cmpe275.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	/*@RequestMapping("/player/{id}")
	public Player getPlayer(@PathVariable long id)
	{
		return playerService.getPlayer(id);
	}*/
	
	@RequestMapping(method=RequestMethod.POST, value="/player")
	public void createPlayer(@RequestBody Player player)
	{
		playerService.createPlayer(player);
	}
	
	@RequestMapping("/allPlayers")
	public List<Player> getAllPlayers()
	{
		return playerService.getAllPlayers();
	}
	
}
