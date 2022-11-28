package com.test.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.entities.Customer;
import com.test.services.CustomerService;

@RestController
public class CustomerController {
	@Autowired(required = false)
	CustomerService customerService;

	private final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

	// http://localhost:PORT/customers (GET)
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> getCustomers() {
		LOG.info("Request a http://localhost:PORT/api/customers (GET)");
		return customerService.findAllCustomers();
	}

	// http://localhost:PORT/customers/1 (GET)
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Customer> getCustomerById(@PathVariable Long id) {
		LOG.info("Request a http://localhost:PORT/api/customers/id (GET)");
		return customerService.findCustomerById(id);
	}
}

