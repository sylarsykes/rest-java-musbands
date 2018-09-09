package org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.builder;

import org.sylrsykssoft.rest.java.musbands.core.controller.resource.FactoryAdminResource;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.builder.AbstractFactoryAdminResourceBuilder;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource.MusicalGenreResourceBuilder;

import lombok.NoArgsConstructor;

/**
 * Factory musical genre resource builder
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@NoArgsConstructor
public class FactoryMusicalGenreAdminResourceBuilder extends AbstractFactoryAdminResourceBuilder<MusicalGenreResourceBuilder, MusicalGenreResource> {

	/**
	 * Constructor
	 * 
	 * @param factoryAdminResource
	 */
	public FactoryMusicalGenreAdminResourceBuilder(final FactoryAdminResource<MusicalGenreResource> factoryAdminResource) {
		super();
		this.adminResource = factoryAdminResource.create();
	}
	
	@Override
	public MusicalGenreResourceBuilder getObject() throws Exception {
		return adminResource.toBuilder();
	}

}
