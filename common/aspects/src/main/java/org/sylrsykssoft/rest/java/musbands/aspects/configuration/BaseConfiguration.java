package org.sylrsykssoft.rest.java.musbands.aspects.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Default configuration.
 * 
 * @author juan.gonzalez.fernandez.jgf
 * @since 0.1.0
 */
@Configuration
@SpringBootConfiguration
@EnableAspectJAutoProxy
@ComponentScan("org.sylrsykssoft.rest.java.musbands.aspects.aspects")
public class BaseConfiguration {

}
