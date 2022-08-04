package com.mmit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity

public class Person implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "person", cascade = { PERSIST, MERGE, REMOVE }, orphanRemoval = true)
	private List<Phone> phones = new ArrayList<Phone>();
	
	public void addPhone(Phone phone) {
		phone.setPerson(this);
		this.phones.add(phone);
	}
	
	
	public List<Phone> getPhones() {
		return phones;
	}


	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Person() {
		super();
	}
   
}
