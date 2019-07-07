package com.hcl.rest.api.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
import com.hcl.rest.api.service.BankOfficerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestContext.class, BankOfficerController.class })
@WebAppConfiguration
public class BankOfficerControllerTest {
	
	@InjectMocks
	BankOfficerController bankOfficerController;

	private MockMvc mockMvc;

	@Mock
	BankOfficerServiceImpl  bankOfficerServiceImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(bankOfficerController).build();
	}
	@Test
	public void approvePersonalLoanTest() throws Exception {
		Customer customer  =  new Customer();
		long accNo=2;
		customer.setAccountNo(accNo);
		customer.setAge(30);
		customer.setCreditScore(1000);
		customer.setWorkExprience(3);
		Mockito.when(bankOfficerServiceImpl.approvePersonalLoan(Mockito.anyLong())).thenReturn("loan approve");
		this.mockMvc.perform(
				get("/bank/officer/approveloan/{accountNo}",accNo).contentType(MediaType.APPLICATION_JSON).content(asJsonString(accNo)))
				.andReturn();
		String str = bankOfficerController.approvePersonalLoan(accNo);
		assertEquals("loan approve", str);
		
	}
	@Test
	public void deleteRejectedPersonalLoanTest() throws Exception {
		Customer customer  =  new Customer();
		long accNo=2;
		customer.setAccountNo(accNo);
		customer.setAge(30);
		customer.setCreditScore(1000);
		customer.setWorkExprience(3);
		Mockito.when(bankOfficerServiceImpl.deleteRejectedPersonalLoan(Mockito.anyLong())).thenReturn("loan deleted");
		this.mockMvc.perform(
				delete("/bank/officer/rejectloan/{accountNo}",accNo).contentType(MediaType.APPLICATION_JSON).content(asJsonString(accNo)))
				.andReturn();
		String str = bankOfficerController.deleteRejectedPersonalLoan(accNo);
		assertEquals("loan deleted", str);
		
	}
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
