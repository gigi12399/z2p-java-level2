package com.mmit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.EnumType.STRING;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;
	@Column(length = 100)
	private String phone;
	@Enumerated(STRING)
	@Column(columnDefinition = "ENUM('male','female')")
	private Gender gender;
	
	public enum Gender{
		male,
		female
	}
	
	@ElementCollection
	@CollectionTable(name = "photos",
	joinColumns = @JoinColumn(name = "customer_id"))
	@Column(length = 200, name = "photo_name")
	private List<String> photos = new ArrayList<String>();

	@OneToOne
	@MapsId
	@JoinColumn(name = "customer_id")
	private User user;
	
	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<String> getPhoto() {
		return photos;
	}

	public void setPhoto(List<String> photo) {
		this.photos = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
   
}
