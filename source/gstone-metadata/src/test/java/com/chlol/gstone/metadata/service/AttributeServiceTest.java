package com.chlol.gstone.metadata.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chlol.gstone.metadata.BaseTest;
import com.chlol.gstone.metadata.model.Attribute;

public class AttributeServiceTest extends BaseTest {
	@Autowired
	private AttributeService as;

	Attribute a = null;

	@Test
	public void testAddAttribute() {
		a = new Attribute();
		a.setName("name");
		a.setLabel("名称");
		a.setType("string");
		a.setLength(128);

		as.save(a);
		Attribute get = as.getAttributeByName(a.getName());
		assertEquals(a.getLabel(), get.getLabel());
	}

	@After
	public void tearDown() throws Exception {
		as.remove(a);
	}

}
