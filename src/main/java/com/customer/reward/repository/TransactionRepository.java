package com.customer.reward.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.reward.model.CustomerTransaction;

@Repository
public interface TransactionRepository extends JpaRepository<CustomerTransaction, Long>{

}
