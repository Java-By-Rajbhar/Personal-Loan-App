package com.hcl.rest.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EMI_Detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EMIDetail {
	
	@Id
	@GeneratedValue
	private int emiId;
	private double interestAmountPerMonth;
	private double remainingAmount;
	private double emiAmout;
	private Date paymentDate;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="loanId")
	private Loan loan;

}
