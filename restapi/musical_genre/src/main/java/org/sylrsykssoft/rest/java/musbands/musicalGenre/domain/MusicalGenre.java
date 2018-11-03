package org.sylrsykssoft.rest.java.musbands.musicalGenre.domain;

import java.beans.ConstructorProperties;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.audit.domain.Audit;
import org.sylrsykssoft.rest.java.musbands.audit.domain.IAuditable;
import org.sylrsykssoft.rest.java.musbands.audit.domain.listener.AuditListener;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;
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
@Table(name = "musical_genre")
@Entity()
@Data()
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter()
@Getter()
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@EntityListeners({AuditListener.class, TranslateListener.class})
public class MusicalGenre extends BaseAdmin implements FactoryAdminDomain<MusicalGenre>, IAuditable, ITranslatable {

	@Embedded
	private Audit audit;
	
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
	@ConstructorProperties({ "id", "name", "description", "audit", "translate"})
	public MusicalGenre(final Integer id, final String name, final String description, final Audit audit, final Translate translate) {
		super(id, name, description);
		this.audit = audit;
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
	public static class MusicalGenreBuilder extends BaseAdminBuilder {

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
			this.audit = base.getAudit();
			this.translate = base.getTranslate();
		}

	}
}
