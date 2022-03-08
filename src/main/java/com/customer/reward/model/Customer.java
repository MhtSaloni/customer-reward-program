package com.customer.reward.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Customer implements Serializable {
	private static final long serialVersionUID = -3396105616734201512L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
	private Long id;
	private String customerName;
	private String address;
	private String email;
	private String phno;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "post_id")
	private List<CustomerTransaction> transactions = new ArrayList<>();
	@Transient
	private Long totalRewards;
}
