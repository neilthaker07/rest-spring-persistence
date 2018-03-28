package com.devcool.software.interview.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devcool.software.interview.exception.PlayerNotFoundException;
import com.devcool.software.interview.model.Player;
import com.devcool.software.interview.repository.PlayerRepository;

@Component
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Transactional 
	public List<Player> getPlayers()
	{
		return playerRepository.findAll();
	}
	
	public Player addPlayer(Player player)
	{
		return playerRepository.save(player);
	}

	public Player getPlayer(Long id)
	{
		Player player = playerRepository.findPlayerById(id);
		if(player != null){
			return player;
		} else {
			throw new PlayerNotFoundException(id);
		}
	}

	@Transactional
	public Player updatePlayer(Player player, Long id) {
		playerRepository.updatePlayerInfo(player.getName(),player.getNum(), id);
		player.setId(id);
		return player;
	}

	public Player deletePlayer(Long id) {
		Player player = playerRepository.findPlayerById(id);
		playerRepository.delete(player);
		return player;
	}

}
