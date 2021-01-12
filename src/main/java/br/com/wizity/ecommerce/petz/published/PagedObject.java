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
 */
public class PagedObject implements Serializable {

	private static final long serialVersionUID = 2112691167340706144L;
	
	private Object item;
	private Integer pages;
	private Integer length;
	
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	
}
