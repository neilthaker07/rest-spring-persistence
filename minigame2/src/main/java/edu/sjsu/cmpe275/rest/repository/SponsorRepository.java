package edu.sjsu.cmpe275.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sjsu.cmpe275.rest.model.Sponsor;

/**
 * DAO layer for the Sponsor extending the JPA specific Spring data repository
 * @author Neil Thaker
 */
public interface SponsorRepository extends JpaRepository<Sponsor, Long>{


}
