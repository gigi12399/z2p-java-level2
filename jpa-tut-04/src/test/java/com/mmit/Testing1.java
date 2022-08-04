package com.mmit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mmit.entity.Order_1;
import com.mmit.entity.OrderItem_1;
@TestMethodOrder(OrderAnnotation.class)
class Testing1 {
	static EntityManagerFactory emf;
	static EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tut-04");
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
	//@Order(1)
	void test() {
		var order = new Order_1();
		order.setOrderDate(LocalDate.now());
		
		var item1 = new OrderItem_1();
		item1.setProductName("Juice");
		item1.setSubQty(4);
		
		order.addItems(item1);
		//var order2 = new Order();
		//order2.setOrderDate(LocalDate.now());
		//order2.addItems(item1);
		
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}
	
	@Test
	void test1() {
		
	}

}
