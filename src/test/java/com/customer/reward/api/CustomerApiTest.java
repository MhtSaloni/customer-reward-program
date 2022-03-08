package com.customer.reward.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.customer.reward.model.Customer;
import com.customer.reward.model.CustomerTransaction;
import com.customer.reward.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerApi.class)
public class CustomerApiTest {
	@MockBean
	private CustomerService customerService;

	@Autowired
    private MockMvc mockMvc;
 

	
	private static ObjectMapper mapper = new ObjectMapper();
	 

 
    @Test
    public void createCustomerTest() throws Exception {
    	Customer customer = new Customer();
    	customer.setCustomerName("testcustomer");
    	customer.setEmail("abc@test.com");
    	customer.setPhno("1234567890");
    	customer.setAddress("testaddress");
    	List<CustomerTransaction> customerTransactions = new ArrayList<>();
    	CustomerTransaction customerTransaction1 = new CustomerTransaction();
    	customerTransaction1.setTransactionAmount(70.0);
    	CustomerTransaction customerTransaction2 = new CustomerTransaction();
    	customerTransaction2.setTransactionAmount(50.0);
    	customerTransactions.add(customerTransaction1);
    	customerTransactions.add(customerTransaction2);
    	customer.setTransactions(customerTransactions);
        Mockito.when(customerService.createCustomer(ArgumentMatchers.any())).thenReturn(customer);
        String json = mapper.writeValueAsString(customer);
        mockMvc.perform(post("/customers").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName", Matchers.equalTo("testcustomer")))
                .andExpect(jsonPath("$.email", Matchers.equalTo("abc@test.com")));
    }
	
	
    @Test
    public void testGetExample() throws Exception {
    	Customer customer = new Customer();
    	customer.setId(1l);
    	customer.setCustomerName("testcustomer");
    	customer.setEmail("abc@test.com");
    	customer.setPhno("1234567890");
    	customer.setAddress("testaddress");
    	List<CustomerTransaction> customerTransactions = new ArrayList<>();
    	CustomerTransaction customerTransaction1 = new CustomerTransaction();
    	customerTransaction1.setTransactionAmount(70.0);
    	CustomerTransaction customerTransaction2 = new CustomerTransaction();
    	customerTransaction2.setTransactionAmount(50.0);
    	customerTransactions.add(customerTransaction1);
    	customerTransactions.add(customerTransaction2);
    	customer.setTransactions(customerTransactions);
    	
        Mockito.when(customerService.getCustomerById("1")).thenReturn(customer);
        mockMvc.perform(get("/customers/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName", Matchers.equalTo("testcustomer")));
    }
	
	
}
