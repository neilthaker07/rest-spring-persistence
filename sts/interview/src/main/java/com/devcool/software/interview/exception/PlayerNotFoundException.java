package com.devcool.software.interview.exception;

public class PlayerNotFoundException extends RuntimeException {
	
	private final Long id ;
	public PlayerNotFoundException(Long id) {
		this.id = id;
	}
	
	public String getMessage()
	{
		return "No player found of this "+ id;
	}
}
