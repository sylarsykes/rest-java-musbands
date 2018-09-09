package org.sylrsykssoft.rest.java.musbands.musicalGenre.domain;

import java.beans.ConstructorProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.core.domain.Audit;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdminAudit;
import org.sylrsykssoft.rest.java.musbands.core.domain.FactoryAdminDomain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "musical_genre")
@Entity()
@Data()
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter()
@Getter()
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
//@EntityListeners(TranslateListener.class)
public class MusicalGenre extends BaseAdminAudit implements FactoryAdminDomain<MusicalGenre> {

//	@Embedded
//	private Translate translate;

	/**
	 * AllArgsContructor
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param locale
	 * @param createdAt
	 * @param updatedAt
	 * @param deletedAt
	 */
	@Builder()
	@ConstructorProperties({ "id", "name", "description", "audit"})
	public MusicalGenre(final Integer id, final String name, final String description, final Audit audit) {
		super(id, name, description, audit);
	}

	/**
	 * MusicalGenreResourceBuilder.
	 * 
	 * @param base Base
	 * @return MusicalGenreResourceBuilder
	 */
	public static MusicalGenreBuilder builder() {
		return new MusicalGenreBuilder();
	}

	/**
	 * MusicalGenreResourceBuilder.
	 * 
	 * @param base MusicalGenreResource
	 * @return MusicalGenreResourceBuilder
	 */
	public static MusicalGenreBuilder builder(final MusicalGenre base) {
		return new MusicalGenreBuilder(base);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.collections4.Factory#create()
	 */
	public MusicalGenre create() {
		return new MusicalGenre();
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class MusicalGenreBuilder extends BaseAdminAuditBuilder {

		/**
		 * Default constructor.
		 */
		public MusicalGenreBuilder() {
			super();
		}

		/**
		 * 
		 * @param base BaseEntity object.
		 */
		public MusicalGenreBuilder(final MusicalGenre base) {
			super(base);
//			this.translate = base.getTranslate();
		}

	}
}
