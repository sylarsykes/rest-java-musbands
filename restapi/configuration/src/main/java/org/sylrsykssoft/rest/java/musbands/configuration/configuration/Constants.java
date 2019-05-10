package org.sylrsykssoft.rest.java.musbands.configuration.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Common constants
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class Constants {

	/**
	 * Constants of datasource configuration
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component
	public static class CDataSourceConfiguration {
		
		public static String HOST;
		public static String PORT;
		public static String ROOT_USERNAME;
		public static String ROOT_PASSWORD;
		public static String DEFAULT_SCHEMA;
		public static String ADMIN_TABLE_SCHEMA;
		public static String USER_SCHEMA;
		
		@Value("${datasource.host}")
		public void setHost(String host) {
			HOST = host;
		}
		
		@Value("${datasource.port}")
		public void setPort(String port) {
			PORT = port;
		}
		
		@Value("${datasource.root.username}")
		public void setRootUsername(String rootUsername) {
			ROOT_USERNAME = rootUsername;
		}
		
		@Value("${datasource.root.password}")
		public void setRootPassword(String password) {
			ROOT_PASSWORD = password;
		}
		
		@Value("${spring.datasource.schema-name}")
		public void setDefaultSchema(String defaultSchema) {
			DEFAULT_SCHEMA = defaultSchema;
		}
		
		@Value("$spring.admin-table-datasource.schema-name{}")
		public void setAdminTableSchema(String adminTableSchema) {
			ADMIN_TABLE_SCHEMA = adminTableSchema;
		}
		
		@Value("${spring.user-datasource.schema-name}")
		public void setUserSchema(String userSchema) {
			USER_SCHEMA = userSchema;
		}
	}
	
	/**
	 * Enum of datasource configuration
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@PropertySource(name = "dataSource", value = { "classpath:database.properties" })
	@RequiredArgsConstructor
	@Getter
	public enum EDataSourceConfiguration {
		HOST("#{dataSource['datasource.host']}"),
		PORT("#{dataSource['datasource.port']}"),
		ROOT_USERNAME("#{dataSource['datasource.root.username']}"),
		ROOT_PASSWORD("#{dataSource['datasource.root.password']}"),
		DEFAULT_SCHEMA("#{dataSource['spring.datasource.schema-name']}"),
		ADMIN_TABLE_SCHEMA("#{dataSource['spring.admin-table-datasource.schema-name']}"),
		USER_SCHEMA("#{dataSource['spring.user-datasource.schema-name']}");
		
		private String value;
		
		EDataSourceConfiguration(final String value) {
			this.value = value;
		}
	}
}
