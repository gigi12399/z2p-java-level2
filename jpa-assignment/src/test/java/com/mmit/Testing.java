package com.mmit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.criteria.internal.ValueHandlerFactory.LongValueHandler;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mmit.entity.Category;
import com.mmit.entity.Customer;
import com.mmit.entity.Customer.Gender;
import com.mmit.entity.Delivery;
import com.mmit.entity.Merchant;
import com.mmit.entity.OrderItem;
import com.mmit.entity.Product;
import com.mmit.entity.User;

@TestMethodOrder(OrderAnnotation.class)
class Testing {

	static EntityManagerFactory emf;
	static EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-assignment");
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

	@Test
	@Order(1)
	void user_customer_insert() {
		var user1 = new User();
		user1.setId(1001);
		user1.setName("Aung Aung");
		user1.setEmail("aung@gmail.com");
		user1.setPassword("aung");
		
		var user2 = new User();
		user2.setId(1002);
		user2.setName("Cherry");
		user2.setEmail("cherry@gmail.com");
		user2.setPassword("cherry");
		
		
		var customer = new Customer();
		customer.setUser(user1);;
		customer.setFirstName("Aung");
		customer.setLastName("Aung");
		customer.setPhone("098765432");
		customer.setGender(Gender.male);
		customer.getPhoto().add("img1");
		customer.getPhoto().add("img2");
		
		em.getTransaction().begin();
		em.persist(user1);
		em.persist(user2);
		em.persist(customer);
		em.getTransaction().commit();
	}
	
	@Test
	@Order(2)
	void merchant_insert() {
		var user = em.find(User.class, 1002);
		
		var merchant = new Merchant();
		merchant.setUser(user);
		merchant.setPrimaryPhone("098765432");
		merchant.setSecondaryPhone("096754326");
		merchant.setShopName("Sakura");
		merchant.setAddress("No.234,South Dagon, Yangon");
		
		em.getTransaction().begin();
		em.persist(merchant);
		em.getTransaction().commit();
	
	}
	
	//@Test
	//@Order(3)
	void customer_remove() {
		var cust = em.find(Customer.class, 1001);
		
		em.getTransaction().begin();
		em.remove(cust);
		em.getTransaction().commit();
	}
	
	@Test
	@Order(3)
	void product_category_insert() {
		var cate1 = new Category();
		cate1.setId(1001);
		cate1.setName("Fruit");
		
		var cate2 = new Category();
		cate2.setId(1002);
		cate2.setName("Juice");
		
		var product1 = new Product();
		product1.setId(1001);
		product1.setName("Blueberry");
		product1.setPrice(5000);
		product1.setCategory(cate1);
		
		var product2 = new Product();
		product2.setId(1002);
		product2.setName("Apple");
		product2.setPrice(1200);
		product2.setCategory(cate1);
		
		em.getTransaction().begin();
		em.persist(cate1);
		em.persist(cate2);
		em.persist(product1);
		em.persist(product2);
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(4)
	void order_orderitem_deli_insert() {
		var cust = em.find(Customer.class, 1001);
		var product1 = em.find(Product.class, 1001);
		var product2 = em.find(Product.class, 1002);
		
		var order = new com.mmit.entity.Order();
		order.setCustomer(cust);
		order.setShippingAddress("Mandalay");
		order.setShippingPhone("097653788");
		order.setTotalAmount(100000);
		order.setOrderDate(LocalDate.now());
		
		var deli = new Delivery();
		deli.setDeliveryMan("Kyaw Kyaw");
		deli.setDeliveryDate(LocalDate.now());
		
		order.addOrderItem(product1, 5);
		order.addOrderItem(product2, 2);
		order.addDelivery(deli);
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
	}
	
	@Test
	@Order(5)
	void remove_one_orderItem() {
		var order = em.find(com.mmit.entity.Order.class, Long.valueOf(1));
		
		em.getTransaction().begin();
		order.getItems().remove(1);
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(6)
	void removeOrder() {
		var order = em.find(com.mmit.entity.Order.class, Long.valueOf(1));
		em.getTransaction().begin();
		em.remove(order);
		em.getTransaction().commit();
	}
		

}
