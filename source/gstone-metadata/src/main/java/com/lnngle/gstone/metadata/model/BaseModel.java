package com.lnngle.gstone.metadata.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {
	private static final long serialVersionUID = -9213156302412213715L;
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
