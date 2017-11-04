package sample.hibernaterest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	private List<Player> players = new ArrayList<Player>(Arrays.asList(
			new Player("neil", 58), new Player("abc", 10)));
	
	public List<Player> getAllPlayers()
	{
		return players;
	}
	
	public Player getPlayer(String name)
	{
		return players.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void updatePlayer(Player player, String name) {
		for(int i=0;i<players.size();i++)
		{
			if(players.get(i).getName().equals(name))
			{
				players.set(i, player);
				return;
			}
		}
	}

	public void deletePlayer(String name) {
		players.removeIf(t -> t.getName().equals(name));
	}
}
