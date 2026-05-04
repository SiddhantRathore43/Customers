package com.Prj.Customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prj.Customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
