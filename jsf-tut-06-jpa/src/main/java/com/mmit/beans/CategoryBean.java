package com.mmit.beans;

import java.util.List;

import com.mmit.entities.Category;
import com.mmit.services.CategoryService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CategoryBean {
	private List<Category> categories;
	
	@Inject
	private CategoryService service;
	@PostConstruct
	private void init() {
		categories = service.findAll();
	}
	public List<Category> getCategories() {
		return categories;
	}
	
}
