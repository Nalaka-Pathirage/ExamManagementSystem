package com.exam.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HelperUtility {

	// serializing instances
	public static String serialize(Object object) {
		String serializedValue = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			serializedValue = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return serializedValue;
	}

	// deserializing instances
	public static <T> Object deserialize(String json, Class<T> model) {

		Object object = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			object = objectMapper.readValue(json, model.getClass());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return object;
	}

}
