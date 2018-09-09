package org.sylrsykssoft.rest.java.musbands.core.domain.builder;

import org.springframework.beans.factory.FactoryBean;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin.BaseAdminBuilder;

/**
 * 
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public abstract class AbstractFactoryAdminBuilder<B extends BaseAdminBuilder, D extends BaseAdmin> implements FactoryBean<B> {

	protected D adminDomain;
	
	@Override
	public Class<?> getObjectType() {
		return getClass();
	}
}
