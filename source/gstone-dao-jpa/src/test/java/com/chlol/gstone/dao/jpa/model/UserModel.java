package com.chlol.gstone.dao.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chlol.gstone.dao.jpa.BaseJpaModel;

@Entity
@Table(name = "g_test_user")
public class UserModel extends BaseJpaModel {
	private static final long serialVersionUID = -2759563312216309531L;
	private String name;
	private Integer old;
	private boolean enabled;

	@Column(name="name",nullable = false, length = 64, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "old")
	public Integer getOld() {
		return old;
	}

	public void setOld(Integer old) {
		this.old = old;
	}

	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
