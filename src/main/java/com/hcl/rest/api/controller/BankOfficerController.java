package com.hcl.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rest.api.service.BankOfficerServiceImpl;

@RestController
@RequestMapping("/bank")
public class BankOfficerController {

	@Autowired
	private BankOfficerServiceImpl officerServiceImpl;
	
	@GetMapping("/officer/loan/{accountNo}/{loanId}")
	public String approvePersonalLoan(@RequestHeader("officer_type") String officerType ,@PathVariable long accountNo,@PathVariable long loanId)
	{
		return officerServiceImpl.approvePersonalLoan(accountNo,officerType,loanId);
	}
	
	@DeleteMapping("/officer/loan/{loanId}")
	public String deleteRejectedPersonalLoan(@RequestHeader("officer_type") String officerType,@PathVariable long loanId)
	{
		return officerServiceImpl.deleteRejectedPersonalLoan(loanId,officerType);
	}
}
