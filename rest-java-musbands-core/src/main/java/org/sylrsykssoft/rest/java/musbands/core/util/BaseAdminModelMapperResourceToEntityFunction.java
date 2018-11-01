package org.sylrsykssoft.rest.java.musbands.core.util;

import java.lang.reflect.ParameterizedType;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseAdminResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;

/**
 * Mapper entity to resource
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Component
public class BaseAdminModelMapperResourceToEntityFunction<R extends BaseAdminResource, T extends BaseAdmin> implements Function<R, T> {

	@Autowired
	private ModelMapper modelMapper;
	
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
