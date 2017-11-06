package edu.sjsu.cmpe275.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	//private Player p1 = null;
	//private PlayerDao playerDao;
	
/*	public Player getPlayer(long id) {
		//return new Player(1, "abc", "bhj", "qqq", "11111111111");
		
		return p1;
	}
*/
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public void createPlayer(Player player) {
	//	playerDao.createPlayerDao(player);
		
		playerRepository.save(player);
		
		//p1 = new Player(player.getId(),player.getFirstname(), player.getLastname(), player.getEmail(), player.getDescription());
	}
	
	
	public List<Player> getAllPlayers()
	{
		List<Player> players = new ArrayList<Player>();
	/*	playerRepository.findAll()
		.forEach(players::add);
		*/
		players.add(new Player("1","qwe","asd","zxc","vbn"));
		return players;
	}
	
}
