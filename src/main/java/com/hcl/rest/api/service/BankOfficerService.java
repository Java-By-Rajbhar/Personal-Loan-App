package com.hcl.rest.api.service;

public interface BankOfficerService {
	
	public String approvePersonalLoan(long accountNo, String officerType,long loanId);
	
	public String deleteRejectedPersonalLoan(long loanId, String officerType);

}
