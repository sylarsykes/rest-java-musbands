package org.sylrsykssoft.rest.java.musbands.core.mapper;

import java.lang.reflect.ParameterizedType;
import java.util.function.Function;

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
public abstract class BaseEntityModelMapperEntityToResourceFunction<T extends BaseEntity, R extends BaseEntityResource> implements Function<T, R> {

	@Autowired
	protected ModelMapper modelMapper;
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public R apply(T source) {
		Class<R> resourceClass = (Class<R>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
		return modelMapper.map(source, resourceClass);
	}
}
