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

import br.com.wizity.ecommerce.petz.entity.Pet;
import br.com.wizity.ecommerce.petz.repository.IPetRepository;

/**
 * @author Gilson de Andrade Silva
 * 
 * Implements business rules of the user.
 *
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
public class PetServiceImpl implements PetService {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);
	
	/**
	 * Set data repositories.
	 */
	@Autowired
	private IPetRepository iPetRepository;
	
	/**
	 * Create new pet.
	 * 
	 * @param Pet
	 * @return Pet if created.
	 */
	@Override
	public Pet create (Pet pet) throws Exception {
		
		logger.info("Creating a new pet.");
		
		try {
			
			return iPetRepository.save(pet);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * Get pet.
	 * 
	 * @param id
	 * @return Pet if found.
	 */
	@Override
	public Optional<Pet> read (Long id) throws Exception {
		
		logger.info("Reading pet by identification.");
		
		try {
			
			return iPetRepository.findById(id);			
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * Update pet.
	 * 
	 * @param id
	 * @param details
	 * @return Pet if found.
	 */
	@Override
	public Pet update (Long id, Pet detail) throws Exception {
		
		logger.info("Updating pet by identification and pet details.");
		
		try {
			
			Optional<Pet> pet = iPetRepository.findById(id); 
			
			if (pet.isPresent()) {				
				return iPetRepository.save(new Pet(id, detail.getName(), detail.getAge(), detail.getCustomer()));
			} 
			
			return null;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Delete pet.
	 * 
	 * @param id
	 * @return True if deleted.
	 */
	@Override
	public boolean delete (Long id) throws Exception {
		
		logger.info("Deleting pet by identification.");
		
		try {
			
			Optional<Pet> pet = iPetRepository.findById(id); 
			
			if (pet.isPresent()) {				
				iPetRepository.deleteById(id);
				return true;
			} 
			
			return false;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
