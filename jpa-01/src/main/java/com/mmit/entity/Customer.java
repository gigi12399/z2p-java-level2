package com.mmit.entity;

import java.io.Serializable;
import javax.persistence.*;


//@Entity

public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name = "customer_code")
	private String customerCode;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
		@AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
	})
	private BasicInfo basicInfo;
	public Customer() {
		super();
	}
   
}
