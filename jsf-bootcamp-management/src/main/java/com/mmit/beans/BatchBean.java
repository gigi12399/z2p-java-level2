package com.mmit.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.mmit.model.entities.Batch;
import com.mmit.model.entities.Level;
import com.mmit.model.services.BatchService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.RequestParameterMap;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class BatchBean implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Inject
	private BatchService service;
	private List<Batch> batches;
	private Batch batch;
	
	@RequestParameterMap
	@Inject
	private Map<String, String> params;
	@PostConstruct
	public void init() {
		String id = params.get("batchId");
		batch = id == null ? new Batch() : service.findById(Integer.parseInt(id));
		
	}
	
	public String save() {
		service.save(batch);
		return "/batch-list?faces-redirect=true";
	}

	public List<Batch> getBatches() {
		batches = service.findAll();
		return batches;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	
	
}

