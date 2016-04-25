package com.lnngle.gstone.dao.common.impl;

import com.lnngle.gstone.dao.common.GenericModel;

public class StringIdModel implements GenericModel<String> {
	private static final long serialVersionUID = 6504764970073800081L;
	private String id;

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String pk) {
		this.id = pk;
	}

}
