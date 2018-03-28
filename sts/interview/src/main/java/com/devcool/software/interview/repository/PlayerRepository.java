package com.devcool.software.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devcool.software.interview.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	@Query("FROM Player p WHERE p.id = :id")
    Player findPlayerById(@Param("id") Long id);
	
	@Modifying
	@Query("update Player p set p.name = :name, p.num=:num where p.id = :id ")
	void updatePlayerInfo(@Param("name") String name, @Param("num") double num, @Param("id") Long id);
}
