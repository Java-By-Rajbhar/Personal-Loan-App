package com.hcl.rest.api.customException;

public class InsufficientCreditScoreException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InsufficientCreditScoreException(String message)
	{
		super(message);
	}

}
