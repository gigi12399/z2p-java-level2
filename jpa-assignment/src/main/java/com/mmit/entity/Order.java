package com.mmit.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@Column(name = "shipping_address")
	private String shippingAddress;
	@Column(name = "shipping_phone", nullable = false)
	private String shippingPhone;
	@Column(name = "total_amount")
	private double totalAmount;
	@Column(name = "order_date")
	private LocalDate orderDate;

	@OneToMany(mappedBy = "order", cascade = { PERSIST, REMOVE }, orphanRemoval = true)
	private List<OrderItem> items = new ArrayList<OrderItem>();

	@OneToOne(mappedBy = "order", cascade = { REMOVE, PERSIST })
	private Delivery deli;
	
	public void addDelivery(Delivery delivery) {
		this.deli = delivery;
		delivery.setOrder(this);
	}
	public void addOrderItem(Product product,int qty) {
		OrderItem item = new OrderItem();
		item.setOrder(this);
		item.setProduct(product);
		item.setSubQty(qty);
		items.add(item);
	}
	public Order() {
		super();
	}
	 public Delivery getDeli() {
		 return deli; 
	 }
	 
	 public void setDeli(Delivery deli) {
		 this.deli = deli;
	 }
	 

	public Customer getCustomer() {
		return customer;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingPhone() {
		return shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

}
