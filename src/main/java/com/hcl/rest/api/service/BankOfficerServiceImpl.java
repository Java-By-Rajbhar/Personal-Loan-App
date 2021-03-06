package com.hcl.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.rest.api.customException.AgeNotValidException;
import com.hcl.rest.api.customException.InsufficientCreditScoreException;
import com.hcl.rest.api.customException.LessWorkExperienceException;
import com.hcl.rest.api.customException.UnauthorisedOfficerException;
import com.hcl.rest.api.entity.BankOfficer;
import com.hcl.rest.api.entity.Customer;
import com.hcl.rest.api.entity.Loan;
import com.hcl.rest.api.repository.BankOfficerRepository;
import com.hcl.rest.api.repository.CustomerRepository;
import com.hcl.rest.api.repository.LoanRepository;

@Service
public class BankOfficerServiceImpl implements BankOfficerService {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	BankOfficerRepository bankOfficerRepository;

	@Override
	public String approvePersonalLoan(long accountNo, String officerType, long loanId) {

		BankOfficer bankOfficer = bankOfficerRepository.findByOfficerType(officerType);
		if (bankOfficer != null && "officer".equals(bankOfficer.getOfficerType())) {
			Customer cust = customerRepository.findByAccountNo(accountNo);
			if (cust != null) {
				if (cust.getCreditScore() > 900) {
					if (cust.getWorkExprience() > 2) {
						if (cust.getAge() >= 22 && cust.getAge() <= 55) {
							Loan loan = loanRepository.findByLoanId(loanId);
							loan.setLoanStatus("approve");
							if (loanRepository.save(loan) != null) {
								return "Loan has approved with loan id " + loan.getLoanId() + " and account number "
										+ accountNo;
							} else {
								throw new RuntimeException("Some error occured in DB");
							}
						} else {
							throw new AgeNotValidException("Age criteria is not matching");
						}
					} else {
						throw new LessWorkExperienceException("Work experience is less!!");
					}
				} else {
					throw new InsufficientCreditScoreException("Credit Score is less!!");
				}
			} else {
				return "Customer does not exist with account number " + accountNo;
			}
		} else {
			throw new UnauthorisedOfficerException("Unauthorised officer !!");
		}

	}

	@Override
	public String deleteRejectedPersonalLoan(long loanId, String officerType) {

		BankOfficer bankOfficer = bankOfficerRepository.findByOfficerType(officerType);
		if (bankOfficer != null && "manager".equals(bankOfficer.getOfficerType())) {
			Loan loan = loanRepository.findByLoanId(loanId);
			if (loan != null) {
				if (loan.getLoanStatus().equals("reject")) {
					loanRepository.deleteById(loan.getLoanId());
					return "Rejected loan has deleted with loan id " + loan.getLoanId();
				} else {
					return "Can't delete loan beacause loan status is " + loan.getLoanStatus();
				}
			} else {
				return "Loan application does not exist with loan id " + loanId + " Please apply loan";
			}
		} else {
			throw new UnauthorisedOfficerException("Unauthorised officer !!");
		}

	}
}
