package com.mmit.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.mmit.model.entities.Course;
import com.mmit.model.services.CourseService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.RequestParameterMap;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CourseBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CourseService service;
	private List<Course> courses;
	private Course course;
	
	@RequestParameterMap
	@Inject
	private Map<String, String> params;
	@PostConstruct
	public void init() {

		courses = service.findAll();
		String id = params.get("courseId");
		course = id == null ? new Course() : service.findById(Integer.parseInt(id));
	}
	
	public String save() {
		service.save(course);
		return "/course-list?faces-redirect=true";
	}
	
	public String delete(int id) {
		System.out.println("course id = " + id);
		service.deleteById(id);
		return "/course-list?faces-redirect=true";
	}

	public List<Course> getCourses() {
		return courses;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
