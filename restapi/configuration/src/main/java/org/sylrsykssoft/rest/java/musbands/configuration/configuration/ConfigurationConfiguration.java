package org.sylrsykssoft.rest.java.musbands.configuration.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect.Loggable;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect.LoggerAspect;

/**
 * Global configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@PropertySource({ "classpath:application.properties", "classpath:logging.properties", "classpath:database.properties" })
public class ConfigurationConfiguration {

//	/**
//	 * Datasource
//	 * 
//	 * @return
//	 */
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource primaryDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	/**
//	 * Admin table Datasource
//	 * 
//	 * @return
//	 */
//	@Bean
//	@ConfigurationProperties(prefix = "spring.admin-table-datasource")
//	public DataSource adminTableDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//	/**
//	 * User Datasource
//	 * 
//	 * @return
//	 */
//	@Bean
//	@ConfigurationProperties(prefix = "spring.user-datasource")
//	public DataSource userDataSource() {
//		return DataSourceBuilder.create().build();
//	}

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
