package org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.admin-table-datasource")
	public DataSource adminTableDataSource() {
		return DataSourceBuilder.create().build();
	}
}
