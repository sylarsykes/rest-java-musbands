package org.sylrsykssoft.rest.java.musbands.core.controller.resource.builder;

import org.springframework.beans.factory.FactoryBean;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseResource;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseResource.BaseResourceBuilder;

/**
 * Factory resource builder.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public abstract class AbstractFactoryResourceBuilder<B extends BaseResourceBuilder, R extends BaseResource> implements FactoryBean<B> {

	protected R resource;

	@Override
	public Class<?> getObjectType() {
		return getClass();
	}
	
}
