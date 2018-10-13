package org.sylrsykssoft.rest.java.musbands.audit.domain;

import java.beans.ConstructorProperties;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Audit User Entity
 * 
 * @author juan.gonzalez.fernandez.jgf
 */
@Entity
@Data()
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter()
@Getter()
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class AuditUser extends BaseEntity {
	
	@Column(name = "username", nullable = false, unique = true, length = 256)
	@NonNull()
	private String username;
	
	@Builder()
	@ConstructorProperties({ "id", "username"})
	public AuditUser(final Long id, final String username) {
		super(id);
		this.username = username;
	}
	
	/**
	 * Builder.
	 * 
	 * @return AuditBuilder
	 */
	public static AuditUserBuilder builder() {
		return new AuditUserBuilder();
	}

	/**
	 * Builder.
	 * 
	 * @param audit
	 * 
	 * @return AuditBuilder
	 */
	public static AuditUserBuilder builder(final AuditUser auditUser) {
		return new AuditUserBuilder(auditUser);
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class AuditUserBuilder extends BaseEntityBuilder {

		/**
		 * Default constructor.
		 */
		public AuditUserBuilder() {
			super();
		}

		/**
		 * 
		 * @param base
		 *            BaseEntity object.
		 */
		public AuditUserBuilder(final AuditUser auditUser) {
			this.username = auditUser.getUsername();
		}
	}

}
