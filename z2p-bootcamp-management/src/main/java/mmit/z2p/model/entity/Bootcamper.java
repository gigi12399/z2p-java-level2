package mmit.z2p.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Batch
 *
 */
@Entity
@Table(name = "bootcampers")
@NamedQuery(name = "getAllBootcampers", query = "SELECT b FROM Bootcamper b ORDER BY b.batch.level.id")
@NamedQuery(name = "getBootcamperByBatchId", query = "SELECT b FROM Bootcamper b WHERE b.batch.id = :batchId")
public class Bootcamper implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone;
	private String email;
	private String address;
	@ManyToOne
	private Batch batch;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Bootcamper() {
		super();
	}

	
	
   
}
