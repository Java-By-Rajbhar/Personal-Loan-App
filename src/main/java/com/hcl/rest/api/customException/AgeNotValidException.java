package com.hcl.rest.api.customException;

public class AgeNotValidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AgeNotValidException(String message)
	{
		super(message);
	}

}
