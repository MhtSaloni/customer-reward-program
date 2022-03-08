package com.customer.reward.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.reward.model.CustomerTransaction;
import com.customer.reward.repository.TransactionRepository;
import com.customer.reward.service.CustomerTransactionService;
@Service
public class CustomerTransactionServiceImpl implements CustomerTransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public CustomerTransaction createTransaction(CustomerTransaction customerTransaction) {
		customerTransaction.setTransactionDate(new Date());
		return transactionRepository.save(customerTransaction);
	}

	@Override
	public List<CustomerTransaction> findAllCustomerTransactions() {
		return transactionRepository.findAll();
	}
}
