package com.hcl.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rest.api.entity.Customer;
import com.hcl.rest.api.entity.Loan;
import com.hcl.rest.api.service.CustomerServiceImpl;

@RestController
@RequestMapping("/bank")
public class CustomerContoller {
	@Autowired
	private CustomerServiceImpl serviceImpl;

	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		System.out.println("from createCustomer controller");
		return serviceImpl.openCustomerAccount(customer);
	}

	@PostMapping("/loan")
	public String applyPersonalLoan(@RequestBody Loan loan) {
		return serviceImpl.applyPersonalLoan(loan);
	}

}
