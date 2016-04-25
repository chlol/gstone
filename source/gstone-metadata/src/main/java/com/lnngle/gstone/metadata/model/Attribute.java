package com.lnngle.gstone.metadata.model;

public class Attribute extends CommonModel {
	private static final long serialVersionUID = -5663950447349720274L;
	
	private String type;
	private int length;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
