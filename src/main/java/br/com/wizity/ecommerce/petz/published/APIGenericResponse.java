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

/**
 * @author Gilson de Andrade Silva
 *
 * Published objects.
 *
 */
public class APIGenericResponse implements Serializable {

	private static final long serialVersionUID = 1503764240637501124L;
	
	private Object result;
	private StatusResponse status;

	public APIGenericResponse (Object result, StatusResponse status) {
		this.result = result;
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public StatusResponse getStatus() {
		return status;
	}

	public void setStatus(StatusResponse status) {
		this.status = status;
	}
	
}
