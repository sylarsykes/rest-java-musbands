package org.sylrsykssoft.rest.java.musbands.audit.domain;

import java.beans.ConstructorProperties;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.audit.domain.listener.BaseAdminAuditListener;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * Entity admin auditable
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
//@EntityListeners({AuditListener.class, BaseAdminAuditListener.class})
@EntityListeners({AuditingEntityListener.class, BaseAdminAuditListener.class})
public class BaseAdminAudit extends BaseAdmin {

	@Column(name = "created_at", nullable = false, insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	protected Date createdAt;

	@CreatedBy
	protected @Nullable String createdBy;

	@Column(name = "updated_at", nullable = true, insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	protected @Nullable Date updatedAt;

	@LastModifiedBy
	protected @Nullable String lastModifiedBy;

	@Column(name = "removed_at", nullable = true, insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	protected @Nullable Date removedAt;

	/**
	 * AllArgsConstructor
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param translate
	 * @param audit
	 */
	@Builder()
	@ConstructorProperties({ "id", "name", "description", "createdAt", "createdBy", "updatedAt", "lastModifiedBy", "removedAt" })
	public BaseAdminAudit(final Integer id, final String name, final String description, final Date createdAt,
			final String createdBy, final Date updatedAt, final String lastModifiedBy, final Date removedAt) {
		super(id, name, description);
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.removedAt = removedAt;
	}

	/**
	 * Builder.
	 * 
	 * @return AdminBuilder
	 */
	public static BaseAdminAuditBuilder builder() {
		return new BaseAdminAuditBuilder();
	}

	/**
	 * Builder.
	 * 
	 * @param base Admin base.
	 * 
	 * @return AdminBuilder
	 */
	public static BaseAdminAuditBuilder builder(final BaseAdminAudit base) {
		return new BaseAdminAuditBuilder(base);
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class BaseAdminAuditBuilder extends BaseAdminBuilder {

		/**
		 * Default constructor.
		 */
		public BaseAdminAuditBuilder() {
			super();
		}

		/**
		 * 
		 * @param base BaseEntity object.
		 */
		public BaseAdminAuditBuilder(final BaseAdminAudit base) {
			super(base);
			this.createdAt = base.createdAt;
			this.updatedAt = base.updatedAt;
			this.createdBy = base.createdBy;
			this.lastModifiedBy = base.lastModifiedBy;
			this.removedAt = base.getRemovedAt();
		}

	}
}
