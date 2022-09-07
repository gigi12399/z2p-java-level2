package com.mmit.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity
@Table(name = "courses")
@NamedQuery(name = "getAllCourse", query = "SELECT c FROM Course c ORDER BY c.level.id")
@NamedQuery(name = "getCourseByLevelId", query = "SELECT c FROM Course c WHERE c.level.id = :levelId")
public class Course implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "level_id")
	private Level level;
	private LocalDate created_at;
	private LocalDate updated_at;
	public Course() {
		super();
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) { 
		this.level = level; 
	}
	 
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public LocalDate getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDate updated_at) {
		this.updated_at = updated_at;
	}
	
	@PrePersist
	public void preInsert() {
		created_at = LocalDate.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updated_at = LocalDate.now();
	}
   
}
