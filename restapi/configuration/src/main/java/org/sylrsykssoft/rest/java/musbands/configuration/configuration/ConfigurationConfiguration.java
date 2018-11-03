package org.sylrsykssoft.rest.java.musbands.configuration.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Global configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableConfigurationProperties
@EnableAutoConfiguration
public class ConfigurationConfiguration {
	
}
