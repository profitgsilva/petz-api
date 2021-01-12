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
package br.com.wizity.ecommerce.petz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wizity.ecommerce.petz.entity.Customer;

/**
 * @author Gilson de Andrade Silva
 * 
 * Define the data repository for user operations.
 *
 */
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
	
	/**
	 * Find customer by identification.
	 * 
	 * @param The identification of user found.
	 * @return Customer if found.
	 */
	public Optional<Customer> findById (Long id);

}
