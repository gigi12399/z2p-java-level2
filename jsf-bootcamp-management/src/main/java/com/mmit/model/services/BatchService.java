package com.mmit.model.services;

import java.util.List;

import com.mmit.model.entities.Batch;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class BatchService {
	@PersistenceContext
	private EntityManager em;
	
	public List<Batch> findAll() {
		TypedQuery<Batch> query = em.createNamedQuery("getAllBatch",Batch.class);
		List<Batch> list = query.getResultList();
		for(var l : list) {
			em.refresh(l);
		}
		return list;
	}

	public Batch findById(int id) {
		
		return em.find(Batch.class, id);
	}

	public void save(Batch batch) {
		if(batch.getId() == 0)
			em.persist(batch);
		else
			em.merge(batch);
		
	}

	public List<Batch> findByLevelId(int lvl_id) {
		return em.createNamedQuery("getBatchByLevelId",Batch.class)
				.setParameter("levelId", lvl_id)
				.getResultList();
	}
}
