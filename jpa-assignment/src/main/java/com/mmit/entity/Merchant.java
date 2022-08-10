package com.mmit.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Merchant
 *
 */
@Entity
@Table(name = "merchants")
public class Merchant implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name = "primary_phone", unique = true, length = 100)
	private String primaryPhone;
	@Column(name = "secondary_phone", length = 100)
	private String secondaryPhone;
	@Column(name = "shop_name", nullable = false, length = 100)
	private String shopName;
	@Column(columnDefinition = "TEXT")
	private String address;
	
	@OneToOne
	@JoinColumn(name = "merchant_id")
	@MapsId
	private User user;
	public Merchant() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrimaryPhone() {
		return primaryPhone;
	}
	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}
	public String getSecondaryPhone() {
		return secondaryPhone;
	}
	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
   
}
