package org.sylrsykssoft.rest.java.musbands.core.mapper;

import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseEntityResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseEntity;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IMapperFunction<T extends BaseEntity, R extends BaseEntityResource> {

	/**
	 * Get concrete entity to resource mapper
	 * 
	 * @return BaseEntityModelMapperEntityToResourceFunction<T, R>
	 */
	BaseEntityModelMapperEntityToResourceFunction<T, R> getMapperEntityToResource();
	
	/**
	 * Get concrete resource to entity mapper
	 * 
	 * @return BaseEntityModelMapperResourceToEntityFunction<R, T>
	 */
	BaseEntityModelMapperResourceToEntityFunction<R, T> getMapperResourceToEntity();
}
