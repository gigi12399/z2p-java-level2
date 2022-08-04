package com.mmit.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Entity implementation class for Entity: Order
 *
 */
//@Entity
//@Table(name = "orders")
public class Order_1 implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate orderDate;
	
	@OneToMany(cascade = PERSIST, mappedBy = "order")
	private List<OrderItem_1> items = new ArrayList<OrderItem_1>();
	
	public void addItems(OrderItem_1 item) {
		this.items.add(item);
		item.setOrder(this);
	}
	public Order_1() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderItem_1> getItems() {
		return items;
	}
	public void setItems(List<OrderItem_1> items) {
		this.items = items;
	}
	
	
   
}
