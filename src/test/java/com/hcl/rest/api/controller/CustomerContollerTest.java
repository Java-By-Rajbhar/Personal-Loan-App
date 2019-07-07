package com.hcl.rest.api.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.rest.api.entity.Customer;
import com.hcl.rest.api.entity.Loan;
import com.hcl.rest.api.service.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestContext.class, CustomerContoller.class })
@WebAppConfiguration
public class CustomerContollerTest {
	
	@InjectMocks
	CustomerContoller customerContoller;

	private MockMvc mockMvc;

	@Mock
	CustomerServiceImpl  customerServiceImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(customerContoller).build();
	}
	
	@Test
	public void createCustomerTest() throws Exception
	{
		Customer customer  =  new Customer();
		long accNo=2;
		customer.setAccountNo(accNo);
		customer.setAge(30);
		Mockito.when(customerServiceImpl.openCustomerAccount(Mockito.any())).thenReturn(customer);
		this.mockMvc.perform(
				post("/bank/customer/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(customer)))
				.andReturn();
		Customer cust = customerContoller.createCustomer(customer);
		assertEquals(30, cust.getAge());
	}
	
	@Test
	public void applyPersonalLoanTest() throws Exception
	{
		Loan loan  =  new Loan();
		long loanId=2;
		loan.setLoanId(loanId);
		Mockito.when(customerServiceImpl.applyPersonalLoan(Mockito.any())).thenReturn("loan");
		this.mockMvc.perform(
				post("/bank/loan/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(loan)))
				.andReturn();
		String str = customerContoller.applyPersonalLoan(loan);
		assertEquals("loan", str);
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
