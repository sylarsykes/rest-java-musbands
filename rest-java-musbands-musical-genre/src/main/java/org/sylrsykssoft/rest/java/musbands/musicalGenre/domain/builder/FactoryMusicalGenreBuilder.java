/**
 * 
 */
package org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.builder;

import org.sylrsykssoft.rest.java.musbands.core.domain.FactoryAdminDomain;
import org.sylrsykssoft.rest.java.musbands.core.domain.builder.AbstractFactoryAdminBuilder;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre.MusicalGenreBuilder;

import lombok.NoArgsConstructor;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@NoArgsConstructor
public class FactoryMusicalGenreBuilder extends AbstractFactoryAdminBuilder<MusicalGenreBuilder, MusicalGenre> {

	/**
	 * Constructor
	 * 
	 * @param factoryAdminDomain
	 */
	public FactoryMusicalGenreBuilder(final FactoryAdminDomain<MusicalGenre> factoryAdminDomain) {
		super();
		this.adminDomain = factoryAdminDomain.create();
	}
	
	@Override
	public MusicalGenreBuilder getObject() throws Exception {
		return adminDomain.toBuilder();
	}

}
