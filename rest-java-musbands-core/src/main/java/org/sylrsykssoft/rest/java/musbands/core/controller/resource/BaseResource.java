package org.sylrsykssoft.rest.java.musbands.core.controller.resource;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
 * DTO Base.
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
public class BaseResource extends ResourceSupport {

	@NonNull()
	@JsonIgnore()
	protected Date createdAt;

	@JsonIgnore()
	protected Date updatedAt;
	
	@JsonIgnore()
	protected Date deletedAt;

	/**
	 * Builder.
	 * 
	 * @param base
	 *            Base
	 * @return BaseBuilder
	 */
	public static BaseResourceBuilder builder() {
		return new BaseResourceBuilder();
	}

	/**
	 * Builder.
	 * 
	 * @param base
	 *            Base
	 * @return BaseBuilder
	 */
	public static BaseResourceBuilder builder(final BaseResource base) {
		return new BaseResourceBuilder(base);
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class BaseResourceBuilder {

		/**
		 * Default constructor.
		 */
		public BaseResourceBuilder() {
			super();
		}

		/**
		 * 
		 * @param base Base object.
		 */
		public BaseResourceBuilder(final BaseResource base) {
			this.createdAt = base.getCreatedAt();
			this.updatedAt = base.getUpdatedAt();
		}

	}
}
