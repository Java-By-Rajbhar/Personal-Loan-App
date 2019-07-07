package com.hcl.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.rest.api.entity.BankOfficer;
import com.hcl.rest.api.entity.Customer;
import com.hcl.rest.api.entity.EMIDetail;
import com.hcl.rest.api.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	public Loan findByCustomer(Customer customer);
	
	public Loan findByOfficer(BankOfficer officer);
	
	public Loan findByEmis(EMIDetail emiDetail);

}
