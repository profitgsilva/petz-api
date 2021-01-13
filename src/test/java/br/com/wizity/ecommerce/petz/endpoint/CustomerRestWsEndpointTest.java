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

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import br.com.wizity.ecommerce.petz.PetzApplicationTest;

/**
 * @author Gilson de Andrade Silva
 *
 */
public class CustomerRestWsEndpointTest extends PetzApplicationTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private CustomerRestWsEndpoint customerRestWsEndpoint;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestWsEndpoint).build();
	}
	
	@Test
	public void testReadCustomer() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/public/read/customer/1")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
