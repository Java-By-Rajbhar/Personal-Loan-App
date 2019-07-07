package com.hcl.rest.api.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.rest.api.entity.Customer;
import com.hcl.rest.api.entity.Loan;
import com.hcl.rest.api.repository.CustomerRepository;
import com.hcl.rest.api.repository.LoanRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Mock
	CustomerRepository customerRepository;
	
	@Mock
	LoanRepository loanRepository;
	
	@Test
	public void openCustomerAccountTest() {
		Customer customer = new Customer();
		customer.setAccountNo(2);
		customer.setCreditScore(100);
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		Customer cust = customerServiceImpl.openCustomerAccount(customer);
		assertEquals(customer.getAccountNo(), cust.getAccountNo());
		
	}
	@Test
	public void applyPersonalLoanTest() {
		Loan loan  = new Loan();
		loan.setLoanId(100);
		loan.setLoanStatus("pending");
		String actual ="Loan has apply successfully";
		Mockito.when(loanRepository.save(Mockito.any())).thenReturn(loan);
		String cust = customerServiceImpl.applyPersonalLoan(loan);
		assertEquals(actual, cust);
		
	}

}
