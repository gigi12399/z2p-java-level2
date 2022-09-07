package com.mmit.model.services;

import java.util.List;


import com.mmit.model.entities.Bootcamper;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class BootcamperService {
	@PersistenceContext
	private EntityManager em;
	
	

	public Bootcamper findById(int id) {
		
		return em.find(Bootcamper.class, id);
	}

	public void save(Bootcamper obj) {
		if(obj.getId() == 0)
			em.persist(obj);
		else
			em.merge(obj);
	}

	public List<Bootcamper> findAll() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getAllBootcampers",Bootcamper.class)
				.getResultList();
	}

	public List<Bootcamper> findByBatchId(int batchId) {
		// TODO Auto-generated method stub
		return em.createNamedQuery("getBootcamperByBatchId",Bootcamper.class)
				.setParameter("batchId", batchId)
				.getResultList();
	}

	public void delete(int id) {
		em.remove(findById(id));
	}

	 
	

	
}
