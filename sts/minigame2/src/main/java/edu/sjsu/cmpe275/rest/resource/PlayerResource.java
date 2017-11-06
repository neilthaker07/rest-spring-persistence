package edu.sjsu.cmpe275.rest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.rest.model.Player;
import edu.sjsu.cmpe275.rest.repository.PlayerRepository;

@RestController
@RequestMapping(value="/player")
public class PlayerResource {

	@Autowired
	PlayerRepository playerRepository;
	
	@GetMapping(value="/all")
	public List<Player> getAllPlayers()
	{
		return playerRepository.findAll();
	}
	
	@PostMapping(value="/create")
	public List<Player> persist(@RequestBody final Player player)
	{
		playerRepository.save(player);
		return playerRepository.findAll();
	}
	
}
