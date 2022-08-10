package mmit.z2p.model.service;

import javax.persistence.EntityManager;

public class LevelService {
	private EntityManager em;
	
	public LevelService(EntityManager em) {
		this.em = em;
	}
}
