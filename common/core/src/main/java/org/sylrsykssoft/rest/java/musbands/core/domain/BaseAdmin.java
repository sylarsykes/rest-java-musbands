package org.sylrsykssoft.rest.java.musbands.core.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;
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

/***
 * Entity admin
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@MappedSuperclass
@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class BaseAdmin implements Persistable<Integer> {

	public static final int MAX_LENGTH_NAME = 256;
	public static final int MAX_LENGTH_DESCRIPTION = 10000;

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	protected Integer id;

	@Column(name = "name", nullable = false, unique = true, length = MAX_LENGTH_NAME)
	@NonNull()
	protected String name;

	@Column(name = "descriptiom", nullable = true, columnDefinition = "TEXT", length = MAX_LENGTH_DESCRIPTION)
	protected @Nullable String description;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.domain.Persistable#isNew()
	 */
	@Override
	public boolean isNew() {
		return null == getId();
	}
	
	/**
	 * Builder.
	 * 
	 * @return AdminBuilder
	 */
	public static BaseAdminBuilder builder() {
		return new BaseAdminBuilder();
	}

	/**
	 * Builder.
	 * 
	 * @param base Admin base.
	 * 
	 * @return AdminBuilder
	 */
	public static BaseAdminBuilder builder(final BaseAdmin base) {
		return new BaseAdminBuilder(base);
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class BaseAdminBuilder {

		/**
		 * Default constructor.
		 */
		public BaseAdminBuilder() {
			super();
		}

		/**
		 * 
		 * @param base BaseEntity object.
		 */
		public BaseAdminBuilder(final BaseAdmin base) {
			this.id = base.getId();
			this.name = base.getName();
			this.description = base.getDescription();
		}
	}
	
}
