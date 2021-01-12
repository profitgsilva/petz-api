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

import br.com.wizity.ecommerce.petz.entity.Customer;
import br.com.wizity.ecommerce.petz.published.APIGenericResponse;
import br.com.wizity.ecommerce.petz.published.StatusResponse;
import br.com.wizity.ecommerce.petz.service.CustomerService;

/**
 * @author Gilson de Andrade Silva
 *
 */
@RestController
public class CustomerRestWsEndpoint {

	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(CustomerRestWsEndpoint.class);	
	
	/**
	 * Set services. 
	 */
	@Autowired
	private CustomerService customerService;
	
	/**
	 * End points definitions. 
	 */	
	@RequestMapping(method = RequestMethod.POST, value = "/public/create/customer", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> create (@RequestBody Customer customer) { 
		
		try {

			return ResponseEntity.ok(new APIGenericResponse(customerService.create(customer), new StatusResponse("Request API is successfully", HttpStatus.CREATED)));
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(false, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/public/read/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> read (@PathVariable(value = "id") Long id) { 
		
		try {

			Optional<Customer> customer = customerService.read(id);
			
			if (customer.isPresent()) {
				
				return ResponseEntity.ok(new APIGenericResponse(customer.get(), new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
			} else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(null, new StatusResponse("Customer not found.", HttpStatus.NOT_FOUND)));
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/public/update/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> update (@PathVariable(value = "id") Long id,  @Valid @RequestBody Customer detail) { 
		
		try {

			Customer customer = customerService.update(id, detail);
			
			if (customer == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(customer, new StatusResponse("Customer not found.", HttpStatus.NOT_FOUND)));
			}
			 
			return ResponseEntity.ok(new APIGenericResponse(customer, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/public/delete/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> delete (@PathVariable(value = "id") Long id) { 
		
		try {

			Boolean deleted = customerService.delete(id);
			
			if (deleted) {
				return ResponseEntity.ok(new APIGenericResponse(deleted, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			}
			 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(deleted, new StatusResponse("Customer not found.", HttpStatus.NOT_FOUND)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
}
