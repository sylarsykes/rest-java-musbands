package org.sylrsykssoft.rest.java.musbands.audit.domain;

import java.beans.ConstructorProperties;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.audit.domain.listener.AuditListener;
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
@EntityListeners(AuditListener.class)
public class BaseAdminAudit extends BaseAdmin implements IAuditable {

	@Embedded
	protected Audit audit;
	
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
	@ConstructorProperties({ "id", "name", "description", "audit"})
	public BaseAdminAudit(final Integer id, final String name, final String description, final Audit audit) {
		super(id, name, description);
		this.audit = audit;
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
	public static class BaseAdminAuditBuilder extends BaseAdminBuilder  {

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
			this.audit = base.getAudit();
		}

		/**
		 * Set createdAt from audit property
		 * 
		 * @param createdAt
		 * @return BaseAdminBuilder
		 */
		public BaseAdminAuditBuilder createdAt(final Date createdAt) {
			this.audit.setCreatedAt(createdAt);
			return this;
		}

		/**
		 * Set updatedAt from audit property
		 * 
		 * @param updatedAt
		 * @return BaseAdminBuilder
		 */
		public BaseAdminAuditBuilder updatedAt(final Date updatedAt) {
			this.audit.setUpdatedAt(updatedAt);
			return this;
		}

		/**
		 * Set deletedAt from audit property
		 * 
		 * @param deletedAt
		 * @return BaseAdminBuilder
		 */
		public BaseAdminAuditBuilder deletedAt(final Date deletedAt) {
			this.audit.setDeletedAt(deletedAt);
			return this;
		}

		/**
		 * Set createdBy from audit property
		 * 
		 * @param createdBy
		 * @return BaseAdminBuilder
		 */
		public BaseAdminBuilder createdBy(final String createdBy) {
			this.audit.setCreatedBy(createdBy);
			return this;
		}

		/**
		 * Set lastModifiedBy from audit property
		 * 
		 * @param lastModifiedBy
		 * @return BaseAdminBuilder
		 */
		public BaseAdminBuilder lastModifiedBy(final String lastModifiedBy) {
			this.audit.setLastModifiedBy(lastModifiedBy);
			return this;
		}

	}
}
