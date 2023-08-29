package com.gudaniel.template.core.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper model = new ModelMapper();		
		model.getConfiguration()
		  .setFieldMatchingEnabled(true)
		  .setFieldAccessLevel(AccessLevel.PRIVATE);		
		return model;
	}
}