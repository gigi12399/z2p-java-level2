package mmit.z2p.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import mmit.z2p.model.entity.Batch;
import mmit.z2p.model.entity.Course;

public class CourseService {
	private EntityManager em;
	
	public CourseService(EntityManager em) {
		this.em = em;
	}

	public List<Course> findAll() {
		System.out.println("--------");
		return em.createNamedQuery("getAllCourse",Course.class).getResultList();
	}

	public Course findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Course.class, id);
	}

	public void save(Course course) {
		em.getTransaction().begin();
		if(course.getId() == 0)
			em.persist(course);
		else
			em.merge(course);
		em.getTransaction().commit();
	}

	public List<Course> findByLevelId(int lvlId) {
		return em.createNamedQuery("getCourseByLevelId",Course.class)
				.setParameter("levelId", lvlId)
				.getResultList();
	}

	public void deleteById(int id) {
		em.getTransaction().begin();
		var course = findById(id);
		em.remove(course);
		em.getTransaction().commit();
	}

	
}
