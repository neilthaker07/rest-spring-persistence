package edu.sjsu.cmpe275.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.sjsu.cmpe275.rest.model.Player;


/**
 * DAO layer for the Player extending the JPA specific Spring data repository
 * @author Neil Thaker
 */
public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	@Query("FROM Player p WHERE p.email = :email")
    Player findPlayerByEmailId(@Param("email") String email);
	
	@Query("FROM Player p WHERE p.sponsor.id = :id")
	List<Player> findPlayersBySponsorId(@Param("id") Long id);
	
}
