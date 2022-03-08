package com.customer.reward.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.reward.model.Customer;
import com.customer.reward.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerApi {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> findAllCustomers() {
		return customerService.findAllCustomers();
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@GetMapping(value = "{id}")
	public Customer getCustomerById(@PathVariable("id") String id) {
		return customerService.getCustomerById(id);
	} 
	

}
