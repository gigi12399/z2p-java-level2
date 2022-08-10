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
import com.mmit.entity.Product_2;
import com.mmit.entity.Order_2;
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
	void test_many_to_one() {
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
	
	//@Test
	//@org.junit.jupiter.api.Order(1)
	void test_many_to_many() {
		var product1 = new Product_2();
		product1.setName("Coffee");
		product1.setPrice(3500);
		
		var product2 = new Product_2();
		product2.setName("Juice");
		product2.setPrice(1500);
		
		var product3 = new Product_2();
		product3.setName("Milk Tea");
		product3.setPrice(2200);
		
		var order = new Order_2();
		order.setOrderDate(LocalDate.now());
		
		order.addProduct(product1);
		order.addProduct(product2);
		order.addProduct(product3);
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}
	 
	//@Test
	//@org.junit.jupiter.api.Order(2)
	void remove_from_order() {
		System.out.println("Remove Product");
		var product = em.find(Product_2.class, 1);
		var order = em.find(Order_2.class, 1);
		
		em.getTransaction().begin();  
		order.removeProduct(product);
		em.getTransaction().commit();
	}
	
	@Test
	void test3() {
		
	}

}
