package com.chlol.gstone.metadata.common;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class JsonUtilsTest {

	@Test
	public void testToJson() {
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("name", "陈红");
		data.put("address", "shanghai");
		data.put("old", 35);
		
		String json = JsonUtils.toJson(data);
		assertEquals("{\"old\":35,\"address\":\"shanghai\",\"name\":\"陈红\"}",json);
	}
}
