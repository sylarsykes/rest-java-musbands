package org.sylrsykssoft.rest.java.musbands.core.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect.Loggable;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect.LoggerAspect;

/**
 * Default configuration.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@SpringBootConfiguration
public class CoreConfiguration {

	/**
	 * Logger aspect.
	 * 
	 * @return
	 */
	@Bean
	public Loggable loggerAspect() {
		return new LoggerAspect();
	}
}
