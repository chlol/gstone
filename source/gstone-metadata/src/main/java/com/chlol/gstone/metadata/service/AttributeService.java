package com.chlol.gstone.metadata.service;

import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.chlol.gstone.metadata.model.Attribute;

@Service
public class AttributeService extends MetadataBaseService<Attribute> {
	public Attribute getAttributeByName(String name) {
		Query query = new BasicQuery("{name:'" + name + "'}");
		return (Attribute) mongoTemplate.findOne(query, Attribute.class);
	}
}
