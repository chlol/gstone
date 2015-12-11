package com.chlol.gstone.dao.common.impl;

import com.chlol.gstone.dao.common.GenericModel;

public class LongIdModel implements GenericModel<Long> {
	private static final long serialVersionUID = 4667557990317099474L;
	private Long id;

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long pk) {
		this.id = pk;
	}

}
