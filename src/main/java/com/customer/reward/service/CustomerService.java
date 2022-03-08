package com.customer.reward.service;

import java.util.List;

import com.customer.reward.model.Customer;

public interface CustomerService {

	List<Customer> findAllCustomers();

	Customer createCustomer(Customer customer);

	Customer getCustomerById(String id);

}
