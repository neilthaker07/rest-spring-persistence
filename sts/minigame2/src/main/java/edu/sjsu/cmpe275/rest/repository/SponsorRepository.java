package edu.sjsu.cmpe275.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sjsu.cmpe275.rest.model.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor, Long>{

}
