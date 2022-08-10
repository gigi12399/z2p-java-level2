package com.mmit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mmit.entity.Customer;
import com.mmit.entity.CustomerService;

@TestMethodOrder(OrderAnnotation.class)
class Testing_1 {

	static EntityManagerFactory emf;
	static EntityManager em;
	private CustomerService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tut-05");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		service = new CustomerService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	@Order(1)
	void saveCustomer() {
		var c1 = new Customer();
		var c2 = new Customer();
		var c3 = new Customer();
		
		c1.setName("Jeon");
		c1.setCity("Yangon");
		c1.setEmail("jeon@gmail.com");
		
		c2.setName("Cherry");
		c2.setCity("Yangon");
		c2.setEmail("cherry@gmail.com");
		c2.setPhone("098765432");
		
		c3.setName("Aung Aung");
		c3.setCity("Mandalay");
		c3.setEmail("aung@gmail.com");
		
		service.save(c1);
		service.save(c2);
		service.save(c3);
		/*
		 * em.getTransaction().begin(); em.persist(c1); em.persist(c2); em.persist(c3);
		 * em.getTransaction().commit();
		 */
	}
	
	@Test
	@Order(2)
	void dynamic_query() {
		// defined query
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.name LIKE :custName", Customer.class);
		query.setParameter("custName", "%aung%");
		List<Customer> list =  query.getResultList();
		System.out.println("size : " + list.size());
	}
	
	@Test
	@Order(3)
	void static_query() {
		var list = service.findByName("aung");
		System.out.println("size: " + list.size());
	}
	
	@Test
	@Order(4)
	void retrieve_singleResult() {
		var customer = service.findByEmail("Cherry@gmail.com");
		System.out.println("Name: " + customer.getName());
		System.out.println("City: " + customer.getCity());
	}
	
	@Test
	@Order(5)
	void execute_update() {
		em.getTransaction().begin();
		
		/*
		 * int count =
		 * em.createQuery("UPDATE Customer c SET c.name = :new_name WHERE c.id = :id")
		 * .setParameter("new_name", "Cherry") .setParameter("id", 1) .executeUpdate();
		 */
		
		int count = em.createQuery("UPDATE Customer c SET c.name = ?1 WHERE c.id = ?2")
				.setParameter(1, "Cherry")
				.setParameter(2, 1)
				.executeUpdate();
		
		em.getTransaction().commit();
		System.out.println("No of affected row: " + count);
	}
	

}
