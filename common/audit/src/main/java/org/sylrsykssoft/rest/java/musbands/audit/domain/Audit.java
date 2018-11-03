package org.sylrsykssoft.rest.java.musbands.audit.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * Entity auditable
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Embeddable
@Data()
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter()
@Getter()
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class Audit {

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
	
	@Column(name = "deleted_at", nullable = true, insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected @Nullable Date deletedAt;

	/**
	 * Builder.
	 * 
	 * @return AuditBuilder
	 */
	public static AuditBuilder builder() {
		return new AuditBuilder();
	}

	/**
	 * Builder.
	 * 
	 * @param audit
	 * 
	 * @return AuditBuilder
	 */
	public static AuditBuilder builder(final Audit audit) {
		return new AuditBuilder(audit);
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class AuditBuilder {

		/**
		 * Default constructor.
		 */
		public AuditBuilder() {
			super();
		}

		/**
		 * 
		 * @param base
		 *            BaseEntity object.
		 */
		public AuditBuilder(final Audit audit) {
			this.createdAt = audit.getCreatedAt();
			this.updatedAt = audit.getUpdatedAt();
			this.deletedAt = audit.getDeletedAt();
			this.createdBy = audit.getCreatedBy();
			this.lastModifiedBy = audit.getLastModifiedBy();
		}
	}
}
