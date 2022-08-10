package mmit.z2p.model.service;

import javax.persistence.EntityManager;

public class BatchService {
	private EntityManager em;
	
	public BatchService(EntityManager em) {
		this.em = em;
	}
}
