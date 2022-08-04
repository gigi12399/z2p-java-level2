package com.mmit.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrderItem
 *
 */
//@Entity

public class OrderItem_1 implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	private int subQty;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order_1 order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSubQty() {
		return subQty;
	}

	public void setSubQty(int subQty) {
		this.subQty = subQty;
	}

	public Order_1 getOrder() {
		return order;
	}

	public void setOrder(Order_1 order) {
		this.order = order;
	}
	
	
	
   
}
