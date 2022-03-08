package com.customer.reward.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.reward.model.Customer;
import com.customer.reward.model.CustomerTransaction;
import com.customer.reward.repository.CustomerRepository;
import com.customer.reward.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		customer.getTransactions().stream().forEach(c -> c.setTransactionDate(new Date()));
		calcualteRewards(customer);

		return customerRepository.save(customer);
	}

	private void calcualteRewards(Customer customer) {
		double totalAmount = customer.getTransactions().stream().mapToDouble(CustomerTransaction::getTransactionAmount)
				.sum();
		long pointsAbovefifty = 0;
		long pointsAboveHundred = 0;
		if (totalAmount > 100) {
			pointsAboveHundred = (int) ((totalAmount - 100) * 2);
			pointsAbovefifty = (int) ((totalAmount - 50) - (totalAmount - 100));
		} else {
			pointsAbovefifty = (int) (totalAmount - 50);
		}

		customer.setTotalRewards(pointsAboveHundred + pointsAbovefifty);

	}

	@Override
	public Customer getCustomerById(String id) {
		Customer customer =  customerRepository.findById(Long.parseLong(id)).get();
		calcualteRewards(customer);
		return customer;
	}
}
