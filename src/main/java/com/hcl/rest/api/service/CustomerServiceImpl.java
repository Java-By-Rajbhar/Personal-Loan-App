package com.hcl.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.rest.api.entity.Customer;
import com.hcl.rest.api.entity.Loan;
import com.hcl.rest.api.repository.CustomerRepository;
import com.hcl.rest.api.repository.LoanRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private LoanRepository loanRepository;

	@Override
	public Customer findByAccountNo(long accountNo) {
		return repository.findByAccountNo(accountNo);
	}

	public Customer openCustomerAccount(Customer customer) {
		
		return repository.save(customer);
	}

	@Override
	public String applyPersonalLoan(Loan loan) {
		Loan loan1  = loanRepository.save(loan);
		if(loan1!=null)
		{
			return "Loan has apply successfully";
		}
		else
		{
			return "Some error occured in DB";
		}
	}

}
