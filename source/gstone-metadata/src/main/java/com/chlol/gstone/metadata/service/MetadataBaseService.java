package com.chlol.gstone.metadata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class MetadataBaseService {
	@Autowired
	protected MongoTemplate mongoTemplate;
}
