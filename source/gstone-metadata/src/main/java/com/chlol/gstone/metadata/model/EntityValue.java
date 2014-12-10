package com.chlol.gstone.metadata.model;

import java.util.ArrayList;
import java.util.List;

public class EntityValue extends BaseModel {
	private static final long serialVersionUID = 5866225221559545060L;
	private String entityName;
	private int entityVersion;
	private List<Value> values;
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public int getEntityVersion() {
		return entityVersion;
	}
	public void setEntityVersion(int entityVersion) {
		this.entityVersion = entityVersion;
	}
	public List<Value> getValues() {
		return values;
	}
	public void setValues(List<Value> values) {
		this.values = values;
	}
	
	public void addValue(Value value) {
		if (values == null) {
			values = new ArrayList<Value>();
		}
		values.add(value);
	}

}
