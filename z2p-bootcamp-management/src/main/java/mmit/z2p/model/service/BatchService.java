package mmit.z2p.model.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mmit.z2p.model.entity.Batch;

public class BatchService {
	private EntityManager em;
	
	public BatchService(EntityManager em) {
		this.em = em;
	}

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
		em.getTransaction().begin();
		if(batch.getId() == 0)
			em.persist(batch);
		else
			em.merge(batch);
		em.getTransaction().commit();
		
	}

	public List<Batch> findByLevelId(int lvl_id) {
		return em.createNamedQuery("getBatchByLevelId",Batch.class)
				.setParameter("levelId", lvl_id)
				.getResultList();
	}
}
