package org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource;

import java.beans.ConstructorProperties;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseAdminResource;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.FactoryAdminResource;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO BaseAdmin
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data()
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PACKAGE)
@Getter()
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
public class MusicalGenreResource extends BaseAdminResource implements FactoryAdminResource<MusicalGenreResource> {

	
	/**
	 * AllArgsContructor
	 * 
	 * @param createdAt
	 * @param updatedAt
	 * @param deletedAt
	 * @param id
	 * @param name
	 * @param description
	 */
	@Builder()
	@ConstructorProperties({ "createdAt", "updatedAt", "deletedAt", "id", "name", "description"})
	public MusicalGenreResource(final Date createdAt, final Date updatedAt, final Date deletedAt, final Integer id,
			final String name, final String description) {
		super(createdAt, updatedAt, deletedAt, id, name, description);
	}
	
	/**
	 * MusicalGenreResourceBuilder.
	 * 
	 * @param base Base
	 * @return MusicalGenreResourceBuilder
	 */
	public static MusicalGenreResourceBuilder builder() {
		return new MusicalGenreResourceBuilder();
	}

	/**
	 * MusicalGenreResourceBuilder.
	 * 
	 * @param base MusicalGenreResource
	 * @return MusicalGenreResourceBuilder
	 */
	public static MusicalGenreResourceBuilder builder(final MusicalGenreResource base) {
		return new MusicalGenreResourceBuilder(base);
	}
	
	@Override
	public MusicalGenreResource create() {
		return new MusicalGenreResource();
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class MusicalGenreResourceBuilder extends BaseAdminResourceBuilder {

		/**
		 * Default constructor.
		 */
		public MusicalGenreResourceBuilder() {
			super();
		}

		/**
		 * 
		 * @param base BaseEntity object.
		 */
		public MusicalGenreResourceBuilder(final MusicalGenreResource base) {
			super(base);
		}
	}

}
