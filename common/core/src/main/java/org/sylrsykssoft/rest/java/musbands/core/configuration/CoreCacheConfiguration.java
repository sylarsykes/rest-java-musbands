package org.sylrsykssoft.rest.java.musbands.core.configuration;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * Cache configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 * 
 * @see https://github.com/eugenp/tutorials/tree/master/spring-all/src/main/java/org/baeldung/caching/config
 *
 */
@Configuration
@EnableCaching
public class CoreCacheConfiguration {

	/**
	 * Cache key generator.
	 * 
	 * @return String
	 */
	@Bean("customKeyGenerator")
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder stringBuilder = new StringBuilder();
				return stringBuilder.append(target.getClass().getSimpleName()).append("_").append(method.getName())
						.append("_").append(StringUtils.arrayToDelimitedString(params, "_")).toString();
			}
		};
	}
}
