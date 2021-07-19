package com.mvc.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.controller.CustomerController;
import com.mvc.model.Customer;
import com.mvc.repository.CustomerRepository;

@Service
public class CustomerService {

	private final static Logger LOGGER = Logger.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository customerRepository;

	public Customer get(int id) {
		LOGGER.info("Get Executed");
		return customerRepository.get(id);
	}

	public boolean register(Customer customer) {
		return customerRepository.register(customer);
	}

	public boolean update(Customer customer) {
		return customerRepository.update(customer);
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return customerRepository.delete(id);
	}
}
