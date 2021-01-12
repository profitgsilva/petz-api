/*
--+
    | Project PETZ API SERVICE - Java Class File : 1.0.0 Data: 12/01/2021
    | Copyright(c) by Wizity Tecnologia LTDA
    |
    | All rights reserved.
    |
    | This software is confidential and proprietary information of
    | Wizity Tecnologia LTDA ("Confidential Information").
    | You shall not disclose such Confidential Information and shall 
    | use it only in accordance with the terms of the license agreement
    | you entered with Wizity Tecnologia LTDA.
 +--
 */
package br.com.wizity.ecommerce.petz.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.wizity.ecommerce.petz.entity.Customer;
import br.com.wizity.ecommerce.petz.repository.ICustomerRepository;

/**
 * @author Gilson de Andrade Silva
 * 
 * Implements business rules of the user.
 *
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
public class CustomerServiceImpl implements CustomerService {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	/**
	 * Set data repositories.
	 */
	@Autowired
	private ICustomerRepository iCustomerRepository;
	
	/**
	 * Create new customer.
	 * 
	 * @param Customer
	 * @return Customer if created.
	 */
	@Override
	public Customer create (Customer customer) throws Exception {
		
		logger.info("Creating a new customer.");
		
		try {
			
			return iCustomerRepository.save(customer);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * Get customer.
	 * 
	 * @param id
	 * @return Customer if found.
	 */
	@Override
	public Optional<Customer> read (Long id) throws Exception {
		
		logger.info("Reading customer by identification.");
		
		try {
			
			return iCustomerRepository.findById(id);			
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * Update customer.
	 * 
	 * @param id
	 * @param details
	 * @return Customer if found.
	 */
	@Override
	public Customer update (Long id, Customer detail) throws Exception {
		
		logger.info("Updating customer by identification and customer details.");
		
		try {
			
			Optional<Customer> customer = iCustomerRepository.findById(id); 
			
			if (customer.isPresent()) {				
				return iCustomerRepository.save(new Customer(id, detail.getName(), detail.getEmail()));
			} 
			
			return null;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Delete customer.
	 * 
	 * @param id
	 * @return True if deleted.
	 */
	@Override
	public boolean delete (Long id) throws Exception {
		
		logger.info("Deleting customer by identification.");
		
		try {
			
			Optional<Customer> customer = iCustomerRepository.findById(id); 
			
			if (customer.isPresent()) {				
				iCustomerRepository.deleteById(id);
				return true;
			} 
			
			return false;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
