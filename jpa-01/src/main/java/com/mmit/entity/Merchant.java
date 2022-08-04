package com.mmit.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Merchant
 *
 */
//@Entity

public class Merchant implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String merchantCode;
	private String shopName;
	
	@Embedded
	private BasicInfo basicInfo;
	public Merchant() {
		super();
	}
   
}
