package com.mmit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BankAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String bank_name;
	private String account_holder;
	private String account_number;
	
	
}
