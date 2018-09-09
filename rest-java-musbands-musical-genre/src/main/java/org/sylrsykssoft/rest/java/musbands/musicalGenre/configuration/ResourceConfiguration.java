package org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.FactoryAdminResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource.MusicalGenreResourceBuilder;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.builder.FactoryMusicalGenreAdminResourceBuilder;

/**
 * Beans domain configuration.
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
@Configuration
@ComponentScan("org.sylrsykssoft.rest.java.musbands.musicalGenre.resource")
public class ResourceConfiguration {

	@Bean
	@Scope(value = "prototype")
	@Lazy(value = true)
	public MusicalGenreResourceBuilder createMusicalGenreResourceBuilder(final FactoryAdminResource<MusicalGenreResource> factory) throws Exception {
		FactoryMusicalGenreAdminResourceBuilder factoryMusicalGenreBuilder = new FactoryMusicalGenreAdminResourceBuilder(factory);
		return factoryMusicalGenreBuilder.getObject();
	}
}
