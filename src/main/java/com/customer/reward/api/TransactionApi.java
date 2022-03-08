package com.customer.reward.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.reward.model.CustomerTransaction;
import com.customer.reward.service.CustomerTransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionApi {
	
	@Autowired
	private CustomerTransactionService customerTransactionService;
	
	@PostMapping
	public CustomerTransaction createTransaction(@RequestBody CustomerTransaction customerTransaction) {
		return customerTransactionService.createTransaction(customerTransaction);
	}
	
	@GetMapping
	public List<CustomerTransaction> findAllCustomerTransactions() {
		return customerTransactionService.findAllCustomerTransactions();
	}
}
