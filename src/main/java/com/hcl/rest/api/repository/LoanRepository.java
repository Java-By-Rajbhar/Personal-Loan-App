package com.hcl.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.rest.api.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	public Loan findByLoanId(long loanId);

}
