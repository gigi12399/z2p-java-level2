package com.mmit.pk;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "users",
	   uniqueConstraints = {
		@UniqueConstraint(columnNames = {"user_name","role_name"})
})
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Column(name = "user_email", nullable = false, unique = true, length = 100)
	private String email;
	@Column(name = "user_name")
	private String userName; 
	
	
	@Column(name = "role_name")
	@Enumerated(STRING)
	private Role role;
	
	enum Role{
		admin,
		staff,
		manager,
		superadmin,
		customer
	}
	public User() {
		super();
	}
   
}
