package org.sylrsykssoft.rest.java.musbands.core.mapper;

import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseAdminResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;

/**
 * Create a instances from Admin mapper
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IAdminMapperFunction<T extends BaseAdmin, R extends BaseAdminResource> {

	/**
	 * Get concrete entity to resource mapper
	 * 
	 * @return BaseAdminModelMapperEntityToResourceFunction<T, R>
	 */
	BaseAdminModelMapperEntityToResourceFunction<T, R> getMapperEntityToResource();
	
	/**
	 * Get concrete resource to entity mapper
	 * 
	 * @return BaseAdminModelMapperResourceToEntityFunction<R, T>
	 */
	BaseAdminModelMapperResourceToEntityFunction<R, T> getMapperResourceToEntity();
}
