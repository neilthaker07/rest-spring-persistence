
package edu.sjsu.cmpe275.rest.model;

public class Sponsor {

	public Sponsor() {
		// TODO Auto-generated constructor stub
	}
	
	public Sponsor(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	private Long id;
	private String name;
    private String description;
    //private Address address;
	
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
	
}
