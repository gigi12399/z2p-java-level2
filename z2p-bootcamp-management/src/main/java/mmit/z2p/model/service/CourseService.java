package mmit.z2p.model.service;

import javax.persistence.EntityManager;

public class CourseService {
	private EntityManager em;
	
	public CourseService(EntityManager em) {
		this.em = em;
	}
}
