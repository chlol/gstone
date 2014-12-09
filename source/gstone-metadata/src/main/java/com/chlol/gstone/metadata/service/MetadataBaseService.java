package com.chlol.gstone.metadata.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class MetadataBaseService<M extends Serializable> {
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	public void save(M model) {
		mongoTemplate.save(model);
	}
	
	public M get(Serializable id, Class<M> modelClass) {
		return mongoTemplate.findById(id,modelClass);
	}
	
	public void remove(M model) {
		mongoTemplate.remove(model);
	}
}
