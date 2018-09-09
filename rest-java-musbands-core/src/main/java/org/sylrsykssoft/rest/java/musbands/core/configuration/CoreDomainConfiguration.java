package org.sylrsykssoft.rest.java.musbands.core.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Beans domain configuration.
 * 
 * Database configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @see database.properties
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableConfigurationProperties
@EnableAutoConfiguration
@ComponentScan("org.sylrsykssoft.rest.java.musbands.core.domain")
public class CoreDomainConfiguration {

}
