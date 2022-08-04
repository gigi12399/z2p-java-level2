package com.mmit.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
//@Entity

public class Product_1 implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	public Product_1() {
		super();
	}
   
}
