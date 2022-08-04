package com.mmit.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.entity.User;

class Testing_2 {
	static EntityManagerFactory emf;
	static EntityManager em;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tut-02");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	//@Test
	void internal_callbacks() {
		var user = new User();
		user.setFirstName("Jeon");
		user.setLastName("Kook");
		
		em.getTransaction().begin();
		em.persist(user);
		//em.detach(user);
		em.getTransaction().commit();
		em.detach(user);
		//var user1 = em.find(User.class, "user_e84150e3-7aaf-40f8-9ff6-334d21556464");
		
		//System.out.println("Full Name: " + user1.getFullName());
	}
	
	//@Test
	void external_callbacks() {
		var user = new User();
		user.setFirstName("Aung");
		user.setLastName("Moe");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		System.out.println("ID: " + user.getId());
	}
	
	//@Test
	void external_cb_remove() {
		/*var user = em.find(User.class, "3f2362ba-b746-4d8c-8c8d-eb4fdd71556f");
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();*/
	}
	
	//@Test
	void test3() {
		var user = new User();
		user.setFirstName("Aung");
		user.setLastName("Aung");
		
		user.setPhones(List.of("11111", "22222"));
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	//@Test
	void test4() {
		var user = em.find(User.class, "user_25fc99cd-e5b7-466f-ab63-c56f82d6f69e");
		
		user.getPhones().add("33333");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

}
