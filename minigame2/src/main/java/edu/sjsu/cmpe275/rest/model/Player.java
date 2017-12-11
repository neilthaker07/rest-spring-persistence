package edu.sjsu.cmpe275.rest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO class for handling the Player information and mapping with Player persistence entity
 * @author Afreen Patel
 *
 */
@Entity
@Table(name = "PLAYER")
public class Player {

	public Player() {

	}

	public Player(String firstname, String lastname, String email, String description) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.description = description;
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="FIRSTNAME")
	private String firstname;
    
	@Column(name="LASTNAME")
	private String lastname;
    
	@Column(name="EMAIL", unique=true)
	private String email;
    
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "SPONSOR_ID")
	private Sponsor sponsor;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade =
	{
	        CascadeType.DETACH,
	        CascadeType.MERGE,
	        CascadeType.REFRESH,
	        CascadeType.PERSIST
	})
	
	@JoinTable(name = "OPPONENT",
		joinColumns = {@JoinColumn(name = "player1", referencedColumnName = "id", nullable = false)},
		inverseJoinColumns = {@JoinColumn(name = "player2", referencedColumnName = "id",nullable = false)})
	
	@JsonIgnoreProperties("opponents")
	private Set<Player> opponents;
	
	@Embedded
    private Address address;
	
   public Set<Player> getOpponents() {
		return opponents;
	}

	public void setOpponents(Set<Player> opponents) {
		this.opponents = opponents;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	
}
