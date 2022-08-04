package com.mmit.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.entity.Batch;
import com.mmit.entity.Student;

class Testing_1 {
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
		em = emf.createEntityManager(); // get entity manager
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}


	//@Test
	void test() {
		// new or transient state
		var student = new Student();
		student.setEmail("aung@gmail.com");
		student.setName("Aung");
		System.out.println("Id before persist: " + student.getId());
		em.getTransaction().begin();
		em.persist(student);// from new to managed state
		em.getTransaction().commit();
		System.out.println("Id after persist: " + student.getId());
	}
	
	@Test
	void test2() {
		var student = new Student();
		student.setEmail("Oo@gamil.com");
		student.setName("Oo");
		
		var batch = new Batch(); // new state
		batch.setName("Batch 1");
		
		student.setBatch(batch);
		
		em.getTransaction().begin();
		em.persist(batch);
		em.persist(student);
		em.getTransaction().commit();
	}
	
	//@Test
	void find() {
		var std = new Student();
		std.setEmail("cherryoo@gmail.com");
		std.setName("Cherry Oo");
		
		var batch = em.find(Batch.class, 1); // managed state // find data from persistence context first
		
		std.setBatch(batch);
		
		em.getTransaction().begin();
		em.persist(std);
		em.getTransaction().commit();
		
		System.out.println("_________________________");
		var batch_1 = em.find(Batch.class, 1);// do not hit database,just retrieve persistence context
	}
	
	//@Test
	void getReference() {
		var std = new Student();
		std.setEmail("chan@gmail.com");
		std.setName("Chan Ei");
		
		var batch = em.getReference(Batch.class, 1); // managed state // just contain id
		
		std.setBatch(batch);
		
		em.getTransaction().begin();
		em.persist(std);
		em.getTransaction().commit();
		
		System.out.println("---------------------");
		System.out.println("Batch name: " + batch.getName());
	}
	
	//@Test
	void detached() {
		var student = em.find(Student.class, 1);// managed class
		//em.detach(student); // managed state to detached state (out of context)
		em.clear(); // detached state(all data of context)
		
		var student_1 = em.merge(student); // from detached to managed state
		
		System.out.println("Contain in context: " + em.contains(student_1));
		
	}
	
	//@Test
	void modified() {
		var std = em.find(Student.class, 1); // managed state
		em.getTransaction().begin();
		std.setName("Jeon"); // update via setXXX()
		em.getTransaction().commit();
	}
	
	//@Test
	void modifiedWithMerge() {
		var std = em.find(Student.class, 1); // managed state
		em.detach(std); // detached state
		
		em.getTransaction().begin();
		std.setEmail("jeon@gmail.com");
		em.merge(std);
		em.getTransaction().commit();
		
		
	}
	
	@Test
	void removed() {
		var std = em.find(Student.class, 1); // managed state
		//em.remove(std); // managed to remove state
		
		//em.clear(); // removed to detached state
		em.getTransaction().begin();
		em.remove(std);
		
		//em.persist(std); // removed to managed state
		em.getTransaction().commit();
		
		System.out.println("contain: " + em.contains(std));
	}

}
