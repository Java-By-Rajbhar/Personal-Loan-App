package com.hcl.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rest.api.service.BankOfficerServiceImpl;

@RestController
@RequestMapping("/bank")
public class BankOfficerController {

	@Autowired
	private BankOfficerServiceImpl officerServiceImpl;
	
	@GetMapping("/officer/approveloan/{accountNo}")
	public String approvePersonalLoan(@PathVariable long accountNo)
	{
		return officerServiceImpl.approvePersonalLoan(accountNo);
	}
	
	@DeleteMapping("/officer/rejectloan/{accountNo}")
	public String deleteRejectedPersonalLoan(@PathVariable long accountNo)
	{
		return officerServiceImpl.deleteRejectedPersonalLoan(accountNo);
	}
}
