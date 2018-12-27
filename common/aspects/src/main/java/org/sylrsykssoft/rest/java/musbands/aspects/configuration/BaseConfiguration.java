package org.sylrsykssoft.rest.java.musbands.aspects.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect.LoggerAspect;

/**
 * Default configuration.
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @since 0.1.0
 */
@Configuration
@SpringBootConfiguration
@EnableAspectJAutoProxy
@ComponentScan("org.sylrsykssoft.rest.java.musbands.aspects")
public class BaseConfiguration {

	
	@Bean
	public LoggerAspect loggerAspect() {
		return new LoggerAspect();
	}
}
