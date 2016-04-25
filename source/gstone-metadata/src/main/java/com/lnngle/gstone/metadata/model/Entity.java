package com.lnngle.gstone.metadata.model;

import java.util.ArrayList;
import java.util.List;

public class Entity extends CommonModel {
	private static final long serialVersionUID = -6196753987143185861L;
	
	private List<Attribute> attributes;

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	public void addAttribute(Attribute attribute) {
		if (attributes == null) {
			attributes = new ArrayList<Attribute>();
		}
		attributes.add(attribute);
	}
	
}
