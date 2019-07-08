package com.hcl.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.rest.api.entity.BankOfficer;

@Repository
public interface BankOfficerRepository extends JpaRepository<BankOfficer, Integer> {
	
	public BankOfficer findByOfficerType(String officerType);

	
}
