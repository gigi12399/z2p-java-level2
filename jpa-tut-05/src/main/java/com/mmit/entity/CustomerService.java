package com.mmit.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CustomerService {

	private EntityManager em;
	
	public CustomerService(EntityManager em) {
		this.em = em;
	}
	public void save(Customer cust) {
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
	}
	
	public List<Customer> findAll(){
		return em.createQuery("SELECT c FROM Customer c",Customer.class)
				.getResultList();
	}
	
	public List<Customer> findByName(String name){
		TypedQuery<Customer> query = em.createNamedQuery("findByName", Customer.class);
		query.setParameter("custName", "%" + name + "%");
		
		var list = query.getResultList();
		return list;
	}
	
	public Customer findByEmail(String mail) {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE email = :email", Customer.class)
				.setParameter("email", mail);
		
		return query.getSingleResult();
	}
}
