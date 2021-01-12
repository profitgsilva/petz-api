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
package br.com.wizity.ecommerce.petz.published;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * @author Gilson de Andrade Silva
 *
 * Published objects.
 *
 */
public class StatusResponse implements Serializable {

	private static final long serialVersionUID = -8892377914502297992L;
	
	private String message;
	private HttpStatus http;
	
	public StatusResponse (String message, HttpStatus http) {
		this.message = message;
		this.http = http;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttp() {
		return http;
	}

	public void setHttp(HttpStatus http) {
		this.http = http;
	}
}
