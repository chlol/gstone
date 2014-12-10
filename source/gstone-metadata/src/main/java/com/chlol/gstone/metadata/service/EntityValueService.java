package com.chlol.gstone.metadata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.chlol.gstone.metadata.common.JsonUtils;
import com.chlol.gstone.metadata.model.EntityValue;

@Service
public class EntityValueService extends MetadataBaseService<EntityValue> {
	public List<EntityValue> getEntityValue(String entityName,int entityVersion) {		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("entityName", entityName);
		data.put("entityVersion", entityVersion);
		Query query = new BasicQuery(JsonUtils.toJson(data));
		
		return mongoTemplate.find(query, EntityValue.class);
	}
}
