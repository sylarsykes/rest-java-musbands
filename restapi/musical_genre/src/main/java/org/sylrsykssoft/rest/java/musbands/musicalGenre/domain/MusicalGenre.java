package org.sylrsykssoft.rest.java.musbands.musicalGenre.domain;

import java.beans.ConstructorProperties;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.audit.domain.BaseAdminAudit;
import org.sylrsykssoft.rest.java.musbands.core.domain.FactoryAdminDomain;
import org.sylrsykssoft.rest.java.musbands.core.domain.ITranslatable;
import org.sylrsykssoft.rest.java.musbands.core.domain.Translate;
import org.sylrsykssoft.rest.java.musbands.core.listener.TranslateListener;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity musical genre
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Table(schema = "musbands_admin_table", name = "musical_genre")
@Entity()
@Data()
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter()
@Getter()
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@EntityListeners({TranslateListener.class})
public class MusicalGenre extends BaseAdminAudit implements FactoryAdminDomain<MusicalGenre>, ITranslatable {

	@Embedded
	private Translate translate;
	
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
	@ConstructorProperties({ "id", "name", "description", "createdAt", "createdBy", "updatedAt", "lastModifiedBy", "removedAt", "translate"})
	public MusicalGenre(final Integer id, final String name, final String description, final Date createdAt,
			final String createdBy, final Date updatedAt, final String lastModifiedBy, final Date removedAt, final Translate translate) {
		super(id, name, description, createdAt, createdBy, updatedAt, lastModifiedBy, removedAt);
		this.translate = translate;
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
			this.translate = base.getTranslate();
		}

	}
}
