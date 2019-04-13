package org.sylrsykssoft.rest.java.musbands.core.mapper;

import java.lang.reflect.ParameterizedType;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseEntityResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseEntity;

/**
 * Mapper entity to resource
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public abstract class BaseEntityModelMapperResourceToEntityFunction<R extends BaseEntityResource, T extends BaseEntity> implements MapperFunction<R, T> {

	@Autowired
	protected ModelMapper modelMapper;
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T apply(R source) {
		Class<T> resourceClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
		return modelMapper.map(source, resourceClass);
	}

}
