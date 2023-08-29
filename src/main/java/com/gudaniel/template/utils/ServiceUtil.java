package com.gudaniel.template.utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

public class ServiceUtil {
	public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {
		return entities.map(objectEntity -> new ModelMapper().map(objectEntity, dtoClass));
	}
}
