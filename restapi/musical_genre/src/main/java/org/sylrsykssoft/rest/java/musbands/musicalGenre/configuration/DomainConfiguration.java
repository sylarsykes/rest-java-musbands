package org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre.MusicalGenreBuilder;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.mapper.MusicalGenreModelMapperEntityToResourceFunction;

/**
 * Beans domain configuration.
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
@Configuration
@ComponentScan("org.sylrsykssoft.rest.java.musbands.musicalGenre.domain")
public class DomainConfiguration {
	
	@Bean
	@Primary
	@Scope(value = "prototype")
	@Lazy(value = true)
	public MusicalGenreBuilder domainBuilder() {
		return MusicalGenre.builder();
	}
	
	@Bean
	@Scope(value = "prototype")
	@Lazy(value = true)
	public MusicalGenreModelMapperEntityToResourceFunction baseAdminModelMapperEntityToResourceFunction() {
		return new MusicalGenreModelMapperEntityToResourceFunction();
	}
	
}
