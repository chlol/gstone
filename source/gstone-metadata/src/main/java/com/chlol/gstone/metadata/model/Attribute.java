package com.chlol.gstone.metadata.model;

public class Attribute extends BaseModel {
	private static final long serialVersionUID = -5663950447349720274L;
	private String name;
	private String label;
	private String type;
	private int length;

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
