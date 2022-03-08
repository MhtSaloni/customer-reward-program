package com.customer.reward.service;

import java.util.List;

import com.customer.reward.model.CustomerTransaction;

public interface CustomerTransactionService {
	CustomerTransaction createTransaction(CustomerTransaction customerTransaction);

	List<CustomerTransaction> findAllCustomerTransactions();
}
