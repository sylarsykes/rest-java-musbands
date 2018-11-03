package org.sylrsykssoft.rest.java.musbands.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.core.listener.BaseEntityListener;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity base.
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
@EntityListeners(BaseEntityListener.class)
public class Base {

	@Column(name = "created_at", nullable = false, insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdAt;

	@Column(name = "updated_at", nullable = true, insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	protected @Nullable Date updatedAt;

	@Column(name = "deleted_at", nullable = true, insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected @Nullable Date deletedAt;

	/**
	 * Builder.
	 * 
	 * @param base Base
	 * @return BaseBuilder
	 */
	public static BaseBuilder builder() {
		return new BaseBuilder();
	}

	/**
	 * Builder.
	 * 
	 * @param base Base
	 * @return BaseBuilder
	 */
	public static BaseBuilder builder(final Base base) {
		return new BaseBuilder(base);
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class BaseBuilder {

		/**
		 * Default constructor.
		 */
		public BaseBuilder() {
			super();
		}

		/**
		 * 
		 * @param base Base object.
		 */
		public BaseBuilder(final Base base) {
			this.createdAt = base.getCreatedAt();
			this.updatedAt = base.getUpdatedAt();
			this.deletedAt = base.getDeletedAt();
		}

	}
}
