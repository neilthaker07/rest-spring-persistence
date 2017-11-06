package edu.sjsu.cmpe275.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sjsu.cmpe275.rest.Player;

@Service
public class PlayerService {
	
	private EntityManagerFactory entityManagerFactory;
	
	public List<Player> getAllPlayers()
	{
		//return new Player(222, "abc", "pqd", "email", "desc");
		entityManagerFactory = Persistence.createEntityManagerFactory("player");
		
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		List<Player> lp = new ArrayList<Player>();
		
		try{
			tx.begin();
			//manager.merge(player);
		//	lp = manager.find(Player.class, "ID");
			tx.commit();
		}
		catch(RuntimeException e){
			tx.rollback();
			throw e;
		}
		finally{
			manager.close();
		}
	
		
		
		
		
		
		List<Player> a1 = new ArrayList<Player>();
		Player u = new Player(88, "neil", "pqd", "email", "desc");
		a1.add(u);
		return a1;
	}

	public void createPlayer(Player player) {

		entityManagerFactory = Persistence.createEntityManagerFactory("player");
		
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		try{
			tx.begin();
			manager.merge(player);
			tx.commit();
		}
		catch(RuntimeException e){
			tx.rollback();
			throw e;
		}
		finally{
			manager.close();
		}
	}
	
	
	
}
