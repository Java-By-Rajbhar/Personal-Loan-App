package com.hcl.rest.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="loan_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

	@Id
	@GeneratedValue
	private long loanId;
	private double securityAmount;
	private String loanStatus;
	private double loanAmount;

}
