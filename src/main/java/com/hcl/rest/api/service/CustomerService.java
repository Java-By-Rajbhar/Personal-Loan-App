package com.hcl.rest.api.service;

import com.hcl.rest.api.entity.Customer;
import com.hcl.rest.api.entity.Loan;

public interface CustomerService {
	
	public Customer findByAccountNo(long accountNo);
	
	public Customer openCustomerAccount(Customer customer);
	
	public String applyPersonalLoan(Loan loan);
	
	
	

}
