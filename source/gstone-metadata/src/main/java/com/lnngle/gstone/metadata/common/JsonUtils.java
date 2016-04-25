package com.lnngle.gstone.metadata.common;

import java.util.Map;

import com.google.gson.Gson;

public class JsonUtils {
	public static String toJson(Map<String,Object> data) {
		Gson gson = new Gson();
		return gson.toJson(data);
	}
}
