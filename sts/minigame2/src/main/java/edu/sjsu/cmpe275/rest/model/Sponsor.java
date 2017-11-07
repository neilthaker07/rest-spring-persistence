
package edu.sjsu.cmpe275.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPONSOR")
public class Sponsor {

	public Sponsor() {
		// TODO Auto-generated constructor stub
	}
	
	public Sponsor(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	@Id
	@Column(name="SPONSOR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="NAME")
	private String name;
    
	@Column(name="DESCRIPTION")
	private String description;
    //private Address address;
	
/*	@OneToOne(mappedBy = "sponsor")
	private Player player;*/
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

/*	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}*/
	
}
