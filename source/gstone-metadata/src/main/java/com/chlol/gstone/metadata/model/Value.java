package com.chlol.gstone.metadata.model;

public class Value extends BaseModel {
	private static final long serialVersionUID = -5942151171032424491L;
	private String attributeName;
	private int attributeVersion;
	private Object attributeValue;

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public int getAttributeVersion() {
		return attributeVersion;
	}

	public void setAttributeVersion(int attributeVersion) {
		this.attributeVersion = attributeVersion;
	}

	public Object getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(Object attributeValue) {
		this.attributeValue = attributeValue;
	}

}
