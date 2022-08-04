package com.mmit.entity;

import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CustomerDetail
 *
 */
@Entity

public class CustomerDetail implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String fullname;
	private String phone;
	@OneToOne
	@JoinColumn(name = "cust_id")
	@MapsId
	private Customer customer; // fieldName + "_" + pkFileName(customer_id)
	public CustomerDetail() {
		super();
	}
   
}
