package com.mmit.entity;

import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Phone
 *
 */
@Entity

public class Phone implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	public int getId() {
		return id;
	}

	

	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public Phone() {
		super();
	}
   
}
