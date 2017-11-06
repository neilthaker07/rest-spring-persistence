package edu.sjsu.cmpe275.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sjsu.cmpe275.rest.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{

}
