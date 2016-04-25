package com.lnngle.gstone.dao.mybatis.model;

import com.lnngle.gstone.dao.common.impl.StringIdModel;

public class TestTable1Model extends StringIdModel {
	private static final long serialVersionUID = -3594931601488332633L;
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
