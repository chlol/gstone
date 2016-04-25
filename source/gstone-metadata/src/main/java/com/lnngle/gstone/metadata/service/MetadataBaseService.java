package com.lnngle.gstone.metadata.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

public abstract class MetadataBaseService<M extends Serializable> {
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	public void save(M model) {
		mongoTemplate.save(model);
	}	
	
	public void remove(M model) {
		mongoTemplate.remove(model);
	}
	
	public M getByName(String name,Class<M> modelClass) {
		Query query = new BasicQuery("{name:'" + name + "'}");
		return (M) mongoTemplate.findOne(query, modelClass);
	}
}
