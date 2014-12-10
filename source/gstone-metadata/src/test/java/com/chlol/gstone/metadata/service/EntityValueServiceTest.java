package com.chlol.gstone.metadata.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chlol.gstone.metadata.BaseTest;
import com.chlol.gstone.metadata.model.Attribute;
import com.chlol.gstone.metadata.model.Entity;
import com.chlol.gstone.metadata.model.EntityValue;
import com.chlol.gstone.metadata.model.Value;

public class EntityValueServiceTest extends BaseTest {
	
	@Autowired
	private EntityService es;
	@Autowired
	private EntityValueService evs;
	
	private Entity phone = null;
	
	@Test
	public void testAddEntity() {
		phone = new Entity();
		phone.setName("phone");
		phone.setLabel("手机");
		phone.setVersion(1);
		
		Attribute type = new Attribute();
		type.setName("type");
		type.setLabel("型号");
		type.setType("String");
		type.setLength(64);
		type.setVersion(1);
		phone.addAttribute(type);
		
		Attribute price = new Attribute();
		price.setName("price");
		price.setLabel("价格");
		price.setType("int");
		price.setVersion(1);
		phone.addAttribute(price);
		
		es.save(phone);
		Entity get = es.getByName(phone.getName(),Entity.class);
		assertEquals(phone.getLabel(), get.getLabel());
		
		List<Attribute> attributes = get.getAttributes();
		assertEquals(2,attributes.size());
		
		Value v1 = new Value();
		v1.setAttributeName(type.getName());
		v1.setAttributeVersion(1);
		v1.setAttributeValue("N7100");		
		
		Value v2 = new Value();
		v2.setAttributeName(price.getName());
		v2.setAttributeVersion(1);
		v2.setAttributeValue(4500);
		
		EntityValue ev = new EntityValue();
		ev.setEntityName(phone.getName());
		ev.setEntityVersion(1);
		ev.addValue(v1);
		ev.addValue(v2);
		
		evs.save(ev);
		List<EntityValue> list = evs.getEntityValue(ev.getEntityName(),1);
		assertEquals(1,list.size());
	}
	
	@After
	public void tearDown() throws Exception {
		es.remove(phone);
	}
}
