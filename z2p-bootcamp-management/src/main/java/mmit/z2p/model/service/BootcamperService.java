package mmit.z2p.model.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mmit.z2p.model.entity.Batch;
import mmit.z2p.model.entity.Bootcamper;

public class BootcamperService {
	private EntityManager em;
	
	public BootcamperService(EntityManager em) {
		this.em = em;
	}

	public Bootcamper findById(int id) {
		
		return em.find(Bootcamper.class, id);
	}

	public void save(Bootcamper obj) {
		em.getTransaction().begin();
		if(obj.getId() == 0)
			em.persist(obj);
		else
			em.merge(obj);
		em.getTransaction().commit();
		
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

	
}
