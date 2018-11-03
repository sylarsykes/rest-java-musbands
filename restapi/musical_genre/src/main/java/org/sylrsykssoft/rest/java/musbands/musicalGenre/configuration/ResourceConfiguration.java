package org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource.MusicalGenreResourceBuilder;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.mapper.MusicalGenreModelMapperResourceToEntityFunction;

/**
 * Beans resource configuration.
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
@Configuration
@ComponentScan("org.sylrsykssoft.rest.java.musbands.musicalGenre.resource")
public class ResourceConfiguration {
	
	@Bean
	@Primary
	@Scope(value = "prototype")
	@Lazy(value = true)
	public MusicalGenreResourceBuilder resourceBuilder() {
		return MusicalGenreResource.builder();
	}
	
	@Bean
	@Scope(value = "prototype")
	@Lazy(value = true)
	public MusicalGenreModelMapperResourceToEntityFunction baseAdminModelMapperResourceToEntityFunction() {
		return new MusicalGenreModelMapperResourceToEntityFunction();
	}
}
