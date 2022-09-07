package com.mmit.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;

/**
 * Entity implementation class for Entity: Batch
 *
 */
@Entity
@Table(name = "batches")
@NamedQuery(name = "getAllBatch", query = "SELECT b FROM Batch b ORDER BY b.level.id")
@NamedQuery(name = "getBatchByLevelId", query = "SELECT b FROM Batch b WHERE b.level.id = :levelId")
public class Batch implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDate startDate;
	
	@ManyToOne
	@JoinColumn(name = "level_id")
	private Level level;
	
	@OneToMany(mappedBy = "batch")
	private List<Bootcamper> bootcampers;
	
	public Batch() {
		super();
	}
	
	public int getTotalBootcamper() {
		return this.bootcampers.size();
	}
	
	public List<Bootcamper> getBootcampers() {
		return bootcampers;
	}

	public void setBootcampers(List<Bootcamper> bootcampers) {
		this.bootcampers = bootcampers;
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
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
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
		Batch other = (Batch) obj;
		return id == other.id;
	}
	
   
}
