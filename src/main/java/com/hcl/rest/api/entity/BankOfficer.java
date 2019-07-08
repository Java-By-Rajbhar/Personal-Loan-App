package com.hcl.rest.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bank_officer")
@Data
@NoArgsConstructor
public class BankOfficer {

	@Id
	@GeneratedValue
	private int officerId;
	private String name;
	private String officerType;
}
