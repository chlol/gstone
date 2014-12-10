package com.chlol.gstone.metadata.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chlol.gstone.metadata.BaseTest;
import com.chlol.gstone.metadata.model.Attribute;
import com.chlol.gstone.metadata.model.Entity;

public class EntityServiceTest extends BaseTest {
	
	@Autowired
	private EntityService es;
	
	private Entity user = null;
	
	@Test
	public void testAddEntity() {
		user = new Entity();
		user.setName("user");
		user.setLabel("用户信息");
		user.setVersion(1);
		
		Attribute name = new Attribute();
		name.setName("name");
		name.setLabel("姓名");
		name.setType("String");
		name.setLength(64);
		name.setVersion(1);
		user.addAttribute(name);
		
		Attribute old = new Attribute();
		old.setName("old");
		old.setLabel("年龄");
		old.setType("int");
		old.setVersion(1);
		user.addAttribute(old);
		
		es.save(user);
		Entity get = es.getByName(user.getName(),Entity.class);
		assertEquals(user.getLabel(), get.getLabel());
		
		List<Attribute> attributes = get.getAttributes();
		assertEquals(2,attributes.size());
	}
	
	@After
	public void tearDown() throws Exception {
		es.remove(user);
	}
}
