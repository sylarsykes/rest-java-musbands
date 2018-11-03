package org.sylrsykssoft.rest.java.musbands.core.controller.resource;

import java.beans.ConstructorProperties;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * DTO BaseAdmin
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Data()
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PACKAGE)
@Getter()
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class BaseAdminResource extends BaseResource {

	protected Integer ID;

	@NonNull()
	protected String name;

	protected String description;
	
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
	public BaseAdminResource(final Date createdAt, final Date updatedAt, final Date deletedAt, final Integer id,
			final String name, final String description) {
		super(createdAt, updatedAt, deletedAt);
		this.ID = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * Builder.
	 * 
	 * @return BaseAdminBuilder
	 */
	public static BaseAdminResourceBuilder builder() {
		return new BaseAdminResourceBuilder();
	}

	/**
	 * Builder.
	 * 
	 * @param base
	 *            BaseEntity base.
	 * 
	 * @return BaseAdminBuilder
	 */
	public static BaseAdminResourceBuilder builder(final BaseAdminResource base) {
		return new BaseAdminResourceBuilder(base);
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class BaseAdminResourceBuilder extends BaseResourceBuilder {

		/**
		 * Default constructor.
		 */
		public BaseAdminResourceBuilder() {
			super();
		}

		/**
		 * 
		 * @param base
		 *            BaseEntity object.
		 */
		public BaseAdminResourceBuilder(final BaseAdminResource base) {
			super(base);
			this.ID = base.ID;
			this.name = base.name;
			this.description = base.description;
		}
	}
}
