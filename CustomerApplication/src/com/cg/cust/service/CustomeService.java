package com.cg.cust.service;

import java.util.List;

import com.cg.cust.dto.Customer;
import com.cg.cust.exception.CustomerException;

public interface CustomeService {
	List<Customer> getAllCustomers() throws CustomerException;
	List<Customer> deleteCustomer(int id) throws CustomerException;
	List<Customer> addCustomer(Customer customer) throws CustomerException;

	List<Customer> updateCustomer(Customer customer) throws CustomerException;
	Customer getCustomerById(int id) throws CustomerException;
	
}
