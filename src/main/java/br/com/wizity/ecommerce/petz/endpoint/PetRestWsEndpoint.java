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
package br.com.wizity.ecommerce.petz.endpoint;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.wizity.ecommerce.petz.entity.Pet;
import br.com.wizity.ecommerce.petz.published.APIGenericResponse;
import br.com.wizity.ecommerce.petz.published.StatusResponse;
import br.com.wizity.ecommerce.petz.service.PetService;

/**
 * @author Gilson de Andrade Silva
 *
 */
@RestController
public class PetRestWsEndpoint {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(PetRestWsEndpoint.class);	
	
	/**
	 * Set services. 
	 */
	@Autowired
	private PetService petService;
	
	/**
	 * End points definitions. 
	 */	
	@RequestMapping(method = RequestMethod.POST, value = "/public/create/pet", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> create (@RequestBody Pet pet) { 
		
		try {

			return ResponseEntity.ok(new APIGenericResponse(petService.create(pet), new StatusResponse("Request API is successfully", HttpStatus.CREATED)));
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(false, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/public/read/pet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> read (@PathVariable(value = "id") Long id) { 
		
		try {

			Optional<Pet> pet = petService.read(id);
			
			if (pet.isPresent()) {
				
				return ResponseEntity.ok(new APIGenericResponse(pet.get(), new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
			} else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(null, new StatusResponse("Pet not found.", HttpStatus.NOT_FOUND)));
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/public/update/pet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> update (@PathVariable(value = "id") Long id,  @Valid @RequestBody Pet detail) { 
		
		try {

			Pet pet = petService.update(id, detail);
			
			if (pet == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(pet, new StatusResponse("Pet not found.", HttpStatus.NOT_FOUND)));
			}
			 
			return ResponseEntity.ok(new APIGenericResponse(pet, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/public/delete/pet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> delete (@PathVariable(value = "id") Long id) { 
		
		try {

			Boolean deleted = petService.delete(id);
			
			if (deleted) {
				return ResponseEntity.ok(new APIGenericResponse(deleted, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			}
			 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(deleted, new StatusResponse("Pet not found.", HttpStatus.NOT_FOUND)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
}
