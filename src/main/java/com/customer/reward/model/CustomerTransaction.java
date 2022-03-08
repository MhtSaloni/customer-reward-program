package com.customer.reward.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CustomerTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_trans_generator")
	private Long id; 
	private Double transactionAmount;
	private Date transactionDate;
}
