package com.chlol.gstone.metadata.model;


public abstract class CommonModel extends BaseModel {
	private static final long serialVersionUID = -5660098823769259390L;
	private String name;
	private String label;
	private int version;

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
