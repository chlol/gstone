package com.lnngle.gstone.metadata.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lnngle.gstone.metadata.BaseTest;
import com.lnngle.gstone.metadata.model.Attribute;

public class AttributeServiceTest extends BaseTest {
	@Autowired
	private AttributeService as;

	Attribute a = null;

	@Test
	public void testAddAttribute() {
		a = new Attribute();
		a.setName("attribute");
		a.setLabel("属性");
		a.setType("string");
		a.setLength(128);
		a.setVersion(1);

		as.save(a);
		Attribute get = as.getByName(a.getName(),Attribute.class);
		assertEquals(a.getLabel(), get.getLabel());
	}

	@After
	public void tearDown() throws Exception {
		as.remove(a);
	}

}
