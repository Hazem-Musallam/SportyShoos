package com.simplelearn.jo.admin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Ehab
 *
 */
@Configuration
public class JacksonConfiguration {

	@Autowired
	public ObjectMapper objectMapper(ObjectMapper objectMapper) {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);

		return objectMapper;
	}
}
