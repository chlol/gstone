package com.chlol.gstone.metadata.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {
	private static final long serialVersionUID = -9213156302412213715L;
	private String id;
	private String name;
	private String label;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
