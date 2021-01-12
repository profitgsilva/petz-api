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

import br.com.wizity.ecommerce.petz.entity.Pet;

/**
 * @author Gilson de Andrade Silva
 * 
 * Service interface to Pet.
 *
 */
public interface PetService {
	
	/**
	 * Create new pet.
	 * 
	 * @param Pet
	 * @return Pet if created.
	 */
	public Pet create (Pet pet) throws Exception;
	
	/**
	 * Get pet.
	 * 
	 * @param id
	 * @return Pet if found.
	 */
	public Optional<Pet> read (Long id) throws Exception;
	
	/**
	 * Update pet.
	 * 
	 * @param id
	 * @param details
	 * @return Pet if found.
	 */
	public Pet update (Long id, Pet detail) throws Exception;
	
	/**
	 * Delete pet.
	 * 
	 * @param id
	 * @return True if deleted.
	 */
	public boolean delete (Long id) throws Exception;
}

