package org.sylrsykssoft.rest.java.musbands.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class BeanUtil implements ApplicationContextAware {

	private static ApplicationContext context;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext(org
	 * .springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	/**
	 * Get bean.
	 * 
	 * @param beanClass
	 * @return T bean
	 */
	public static <T> T getBean(Class<T> beanClass) {
		return context.getBean(beanClass);
	}
}
