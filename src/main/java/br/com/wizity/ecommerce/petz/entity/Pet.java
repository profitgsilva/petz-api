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
package br.com.wizity.ecommerce.petz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Gilson de Andrade Silva
 *
 */
@Entity
@Table(name = "Pets", schema="petz_service_schema")
public class Pet extends BaseEntity<Long> {

	private static final long serialVersionUID = 3343975801362476862L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPet", nullable=false, unique=true, insertable=true, updatable=true )
	private Long id;
	
	@Column(name="name",  length=250, nullable=false, unique=false)
	private String name;
	
	@Column(name="age", nullable=false, unique=false)
	private Integer age;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCustomer")
	private Customer customer;

	public Pet() {		
	}
	
	public Pet(Long id, String name, Integer age, Customer customer) {	
		
		super();
		this.id = id;			
		this.name = name;
		this.age = age;
		this.customer = customer;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}