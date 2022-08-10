package com.mmit.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Entity implementation class for Entity: Order
 *
 */
//@Entity
@Table(name = "orders")
public class Order_2 implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate orderDate;
	@ManyToMany(cascade = PERSIST, mappedBy = "orders")
	private List<Product_2> products = new ArrayList<Product_2>();
	public Order_2() {
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
	public List<Product_2> getProducts() {
		return products;
	}
	public void setProducts(List<Product_2> products) {
		this.products = products;
	}
	public void addProduct(Product_2 product) {
		product.getOrders().add(this);
		this.products.add(product);
		
	}

	public void removeProduct(Product_2 product) {
		product.getOrders().remove(this);
		this.products.remove(product);
		
	}
   
}
