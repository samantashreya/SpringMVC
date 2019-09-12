package com.cg.cust.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.cust.dao.CustomerRepository;
import com.cg.cust.dto.Customer;
import com.cg.cust.exception.CustomerException;
@Service
@Transactional
public class CustomerServiceImpl  implements CustomeService{
	@Autowired
	private CustomerRepository customerDao;
	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		
		try {
			return customerDao.findAll();
		} catch (Exception e) {
			throw new CustomerException(e.getMessage());
		}
	}
	@Override
	public List<Customer> deleteCustomer(int id) throws CustomerException {
		try {
			customerDao.delete(id);
			return getAllCustomers();
		} catch (CustomerException e) {
			throw new CustomerException(e.getMessage());
		}
	}
	
	


	@Override
	public List<Customer> addCustomer(Customer customer) throws CustomerException {
		try {
			customerDao.save(customer);
			return getAllCustomers();
		} catch (CustomerException e) {
			throw new CustomerException(e.getMessage());
		}
	}
	 @Override
	    public Customer getCustomerById(int id) throws CustomerException {
	        try {
	            return  customerDao.findOne(id);
	        } catch (Exception e) {
	            throw new CustomerException(e.getMessage());
	        }
	    }

	 

	    @Override
	    public List<Customer> updateCustomer(Customer customer) throws CustomerException {
	        
	        try {
	            customerDao.save(customer);
	            return getAllCustomers();
	        } catch (Exception e) {
	            throw new CustomerException(e.getMessage());
	        }
	    }
	
	}
