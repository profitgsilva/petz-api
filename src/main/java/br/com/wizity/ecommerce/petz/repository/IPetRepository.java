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

import br.com.wizity.ecommerce.petz.entity.Pet;

/**
 * @author Gilson de Andrade Silva
 * 
 * Define the data repository for pet operations.
 *
 */
public interface IPetRepository extends JpaRepository<Pet, Long> {
	
	/**
	 * Find pet by identification.
	 * 
	 * @param The identification of pet found.
	 * @return Customer if found.
	 */
	public Optional<Pet> findById (Long id);

}
