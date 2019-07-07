package com.hcl.rest.api.service;

public interface BankOfficerService {
	
	public String approvePersonalLoan(long accountNo);
	
	public String deleteRejectedPersonalLoan(long accountNo);

}
