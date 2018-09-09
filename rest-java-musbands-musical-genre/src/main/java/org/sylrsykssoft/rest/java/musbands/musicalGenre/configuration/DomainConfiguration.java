package org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.sylrsykssoft.rest.java.musbands.core.domain.FactoryAdminDomain;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre.MusicalGenreBuilder;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.builder.FactoryMusicalGenreBuilder;

/**
 * Beans domain configuration.
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
@Configuration
@ComponentScan("org.sylrsykssoft.rest.java.musbands.musicalGenre.domain")
public class DomainConfiguration {
	
	@Bean
	@Scope(value = "prototype")
	@Lazy(value = true)
	public MusicalGenreBuilder createMusicalGenreBuilder(FactoryAdminDomain<MusicalGenre> factory) throws Exception {
		FactoryMusicalGenreBuilder factoryMusicalGenreBuilder = new FactoryMusicalGenreBuilder(factory);
		return factoryMusicalGenreBuilder.getObject();
	}
}
