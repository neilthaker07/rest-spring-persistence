package edu.sjsu.cmpe275.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Player {

	public Player() {

	}

	public Player(Long id, String firstname, String lastname, String email, String description) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.description = description;
	}
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="FIRSTNAME")
	private String firstname;
    
	@Column(name="LASTNAME")
	private String lastname;
    
	@Column(name="EMAIL")
	private String email;
    
	@Column(name="DESCRIPTION")
	private String description;
	
	/*@Column(name="SPONSOR")
	private Sponsor sponsor;
	*/
 /*   private Address address;
    private List<Player> opponents;*/

  /*  public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}*/

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
	public Sponsor getSponsor() {
		return sponsor;
	}
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	public List<Player> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<Player> opponents) {
		this.opponents = opponents;
	}*/
	
}
