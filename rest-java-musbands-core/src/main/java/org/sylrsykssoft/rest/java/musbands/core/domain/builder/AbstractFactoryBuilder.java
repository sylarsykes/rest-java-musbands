package org.sylrsykssoft.rest.java.musbands.core.domain.builder;

import org.springframework.beans.factory.FactoryBean;
import org.sylrsykssoft.rest.java.musbands.core.domain.Base;
import org.sylrsykssoft.rest.java.musbands.core.domain.Base.BaseBuilder;

/**
 * 
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public abstract class AbstractFactoryBuilder<B extends BaseBuilder, D extends Base> implements FactoryBean<B> {

	protected D domain;

	@Override
	public Class<?> getObjectType() {
		return getClass();
	}
}
