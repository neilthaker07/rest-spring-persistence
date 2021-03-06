package edu.sjsu.cmpe275.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.rest.Player;
import edu.sjsu.cmpe275.services.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
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
