package org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration;

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
public class MusicalGenreConstants {

	/**
	 * Constants of datasource configuration
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component
	public static class CMusicalGenreDataSourceConfiguration {
		
		public static String MUSICAL_GENRE_TABLE;
		
		@Value("${spring.musbands_admin_table.musical-genre}")
		public void setMusicalGenreTable(String musicalGenreTable) {
			MUSICAL_GENRE_TABLE = musicalGenreTable;
		}
	}
	
	/**
	 * Enum of datasource configuration
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@PropertySource(name = "dataSource", value = { "classpath:musicalGenre.properties" })
	@RequiredArgsConstructor
	@Getter
	public enum EMusicalGenreDataSourceConfiguration {
		MUSICAL_GENRE_TABLE("#{dataSource['spring.user-datasource.schema-name']}");
		
		private String value;
		
		EMusicalGenreDataSourceConfiguration(final String value) {
			this.value = value;
		}
	}
}
