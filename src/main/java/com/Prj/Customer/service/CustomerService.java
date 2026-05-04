package com.Prj.Customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prj.Customer.model.Customer;
import com.Prj.Customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	
	public List<Customer> getAllCustomers(){
		return repo.findAll();
	}
	
	public Customer getOneCustomer(Long id) {
		
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Error Customer not Found"));
	}
	
	public Customer createCustomer(Customer cc) {
		return repo.save(cc);
		
	}
	
	public Customer update(Long id, Customer cc) {
		return repo.findById(id).map((c) -> {
			c.setName(cc.getName());
			c.setEmail(cc.getEmail());
			c.setOrderdish(cc.getOrderdish());
			return repo.save(c);
		}).orElseThrow(() -> new RuntimeException("not found"));
		}

	
	public String deleteCustomer(Long id) {
		return "Customer Deleted";
		
	}
	
}

	

