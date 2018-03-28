package com.devcool.software.interview.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devcool.software.interview.model.Player;
import com.devcool.software.interview.service.PlayerService;

@RestController //@RequestMapping("/api") common path for all apis in this class
public class PlayerResource {

	@Autowired
	PlayerService playerService;
	
	@RequestMapping(method=RequestMethod.GET, value="/allPlayers") // @RequestParams if pass values in URL
	List<Player> getAllPlayers()
	{
		return playerService.getPlayers();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/player/{id}")
	Player getPlayer(@PathVariable Long id)
	{
		return playerService.getPlayer(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/player")
	Player addPlayer(@RequestBody Player player)
	{
		return playerService.addPlayer(player);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/player/{id}")
	Player updatePlayer(@RequestBody Player player, @PathVariable Long id)
	{
		return playerService.updatePlayer(player, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/player/{id}")
	Player deletePlayer(@PathVariable Long id)
	{
		return playerService.deletePlayer(id);
	}
	
}
