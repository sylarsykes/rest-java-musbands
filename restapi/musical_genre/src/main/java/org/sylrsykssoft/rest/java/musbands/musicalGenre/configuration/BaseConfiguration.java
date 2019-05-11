package org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Default configuration.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@PropertySource({ "classpath:database.properties", "classpath:musicalGenre.properties" })
@EnableConfigurationProperties
public class BaseConfiguration {

	
	/**
	 * Admin table Datasource
	 * 
	 * @return
	 */
	@Qualifier("adminTableDataSource")
	private DataSource adminTableDataSource; 
}
