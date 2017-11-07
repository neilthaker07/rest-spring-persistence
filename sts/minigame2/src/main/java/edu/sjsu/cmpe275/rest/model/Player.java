package edu.sjsu.cmpe275.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    
	@Column(name="EMAIL")
	private String email;
    
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "SPONSOR_ID")
	private Sponsor sponsor;

 /*   private Address address;
    private List<Player> opponents;*/

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
/*	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Player> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<Player> opponents) {
		this.opponents = opponents;
	}*/

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	
}
