package org.sylrsykssoft.rest.java.musbands.core.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Controller configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@ComponentScan("org.sylrsykssoft.rest.java.musbands.core.controller")
public class CoreControllerConfiguration {

	/**
	 * ModelMapper bean
	 * 
	 * @return ModelMapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
