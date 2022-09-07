package com.mmit.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

/**
 * Entity implementation class for Entity: Level
 *
 */
@Entity
@Table(name = "levels")
@NamedQuery(name = "getAllLevel", query = "SELECT l FROM Level l")
public class Level implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int duration;
	private int fees;
	@OneToMany(mappedBy = "level")
	private List<Batch> batches = new ArrayList<Batch>();
	@OneToMany(mappedBy = "level")
	private List<Course> courses = new ArrayList<Course>();
	public Level() {
		super();
	}
	
	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getTotalCourse() {
		return courses.size();
	}
	public int getTotalBatch() { //totalBatch
		return batches.size();
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		return id == other.id;
	}
	
   
}
