
package edu.sjsu.cmpe275.rest.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO class for handling the Sponsor information and mapping with Sponsor persistence entity
 * @author Neil Thaker
 *
 */
@Entity
@Table(name = "SPONSOR")
public class Sponsor {

	public Sponsor() {
		
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
	
    @Embedded
    private Address address;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
