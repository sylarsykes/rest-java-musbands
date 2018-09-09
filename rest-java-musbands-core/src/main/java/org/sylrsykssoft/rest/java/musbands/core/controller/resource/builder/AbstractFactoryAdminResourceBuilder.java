package org.sylrsykssoft.rest.java.musbands.core.controller.resource.builder;

import org.springframework.beans.factory.FactoryBean;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseAdminResource;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseAdminResource.BaseAdminResourceBuilder;

/**
 * Factory resource builder.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public abstract class AbstractFactoryAdminResourceBuilder<B extends BaseAdminResourceBuilder, R extends BaseAdminResource> implements FactoryBean<B> {

	protected R adminResource;

	@Override
	public Class<?> getObjectType() {
		return getClass();
	}
	
}
