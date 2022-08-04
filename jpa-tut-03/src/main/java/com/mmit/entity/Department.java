package com.mmit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.CascadeType.PERSIST;

/**
 * Entity implementation class for Entity: Department
 *
 */
@Entity
@Table(name = "departments")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = PERSIST)
	private List<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee emp) {
		emp.setDepartment(this);
		this.employees.add(emp);
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


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public Department() {
		super();
	}
   
}
