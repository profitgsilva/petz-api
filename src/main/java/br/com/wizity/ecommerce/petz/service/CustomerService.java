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

import br.com.wizity.ecommerce.petz.entity.Customer;

/**
 * @author Gilson de Andrade Silva
 * 
 * Service interface to Customer.
 *
 */
public interface CustomerService {
	
	/**
	 * Create new customer.
	 * 
	 * @param Customer
	 * @return Customer if created.
	 */
	public Customer create (Customer user) throws Exception;
	
	/**
	 * Get customer.
	 * 
	 * @param id
	 * @return Customer if found.
	 */
	public Optional<Customer> read (Long id) throws Exception;
	
	/**
	 * Update customer.
	 * 
	 * @param id
	 * @param details
	 * @return Customer if found.
	 */
	public Customer update (Long id, Customer detail) throws Exception;
	
	/**
	 * Delete customer.
	 * 
	 * @param id
	 * @return True if deleted.
	 */
	public boolean delete (Long id) throws Exception;
}

