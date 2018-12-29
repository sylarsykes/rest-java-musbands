package org.sylrsykssoft.rest.java.musbands.aspects.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect.Loggable;
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
@PropertySource({"classpath:logging.properties"})
@ComponentScan("org.sylrsykssoft.rest.java.musbands.aspects")
public class BaseConfiguration {


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
