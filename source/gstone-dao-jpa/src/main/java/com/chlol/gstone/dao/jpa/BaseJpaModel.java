package com.chlol.gstone.dao.jpa;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.chlol.gstone.dao.common.impl.StringIdModel;

@MappedSuperclass
public abstract class BaseJpaModel extends StringIdModel {
	private static final long serialVersionUID = 4437615428667954606L;
	protected String id;
	
	@Id
	@Column(name = "ID", nullable = false, updatable = false, length = 32)
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
}
