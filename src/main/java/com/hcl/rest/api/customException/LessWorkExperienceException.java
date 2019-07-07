package com.hcl.rest.api.customException;

public class LessWorkExperienceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LessWorkExperienceException(String message)
	{
		super(message);
	}

}
