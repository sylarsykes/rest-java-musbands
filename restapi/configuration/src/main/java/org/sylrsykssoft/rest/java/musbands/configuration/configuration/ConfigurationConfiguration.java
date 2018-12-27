package org.sylrsykssoft.rest.java.musbands.configuration.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect.LoggerAspect;

/**
 * Global configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@PropertySource({"classpath:application.properties", "classpath:logging.properties", "classpath:database.properties"})
@EnableConfigurationProperties
@EnableAutoConfiguration
public class ConfigurationConfiguration {
	
	@Bean
	public LoggerAspect loggerAspect() {
		return new LoggerAspect();
	}
}
