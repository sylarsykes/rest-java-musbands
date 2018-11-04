package org.sylrsykssoft.rest.java.musbands.audit.domain;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.audit.domain.listener.AuditListener;

import lombok.AccessLevel;
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
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
@EntityListeners(AuditListener.class)
public class BaseAuditUser implements Persistable<Long>, Auditable<AuditUser, Long, LocalDateTime> {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	protected Long id;
	
	@ManyToOne
	protected @Nullable AuditUser createdBy;

	@Column(name = "created_at", nullable = false, insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected @Nullable Date createdDate;

	@ManyToOne
	protected @Nullable AuditUser lastModifiedBy;

	@Column(name = "updated_at", nullable = true, insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	protected @Nullable Date lastModifiedDate;

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
	@ConstructorProperties({"id", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"})
	public BaseAuditUser(final Long id, final AuditUser createdBy, final Date createdDate, final AuditUser lastModifiedBy, final Date lastModifiedDate) {
		this.id = id;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.domain.Persistable#isNew()
	 */
	@Transient // DATAJPA-622
	public boolean isNew() {
		return null == getId();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.domain.Auditable#getCreatedBy()
	 */
	@Override
	public Optional<AuditUser> getCreatedBy() {
		return Optional.ofNullable(createdBy);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.domain.Auditable#getCreatedDate()
	 */
	@Override
	public Optional<LocalDateTime> getCreatedDate() {
		return null == createdDate ? Optional.empty()
				: Optional.of(LocalDateTime.ofInstant(createdDate.toInstant(), ZoneId.systemDefault()));
	}
	
	@Override
	@Deprecated
	public void setCreatedDate(LocalDateTime creationDate) {
		this.setCreatedDate(creationDate);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.domain.Auditable#getLastModifiedBy()
	 */
	@Override
	public Optional<AuditUser> getLastModifiedBy() {
		return Optional.ofNullable(lastModifiedBy);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.domain.Auditable#getLastModifiedDate()
	 */
	@Override
	public Optional<LocalDateTime> getLastModifiedDate() {
		return null == lastModifiedDate ? Optional.empty()
				: Optional.of(LocalDateTime.ofInstant(lastModifiedDate.toInstant(), ZoneId.systemDefault()));
	}
	
	@Override
	@Deprecated
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.setLastModifiedDate(lastModifiedDate);
	}

	/**
	 * Builder.
	 * 
	 * @return AdminBuilder
	 */
	public static BaseAuditUserBuilder builder() {
		return new BaseAuditUserBuilder();
	}
	
	/**
	 * Builder.
	 * 
	 * @return AdminBuilder
	 */
	public static BaseAuditUserBuilder builder(BaseAuditUser base) {
		return new BaseAuditUserBuilder(base);
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class BaseAuditUserBuilder  {

		/**
		 * Default constructor.
		 */
		public BaseAuditUserBuilder() {
			super();
		}
		
		public BaseAuditUserBuilder(BaseAuditUser base) {
			this.id = base.getId();
			this.createdBy = base.getCreatedBy().get();
			this.createdDate = Date.from(base.getCreatedDate().get().toInstant(ZoneOffset.UTC));
			this.lastModifiedBy = base.getLastModifiedBy().get();
			this.lastModifiedDate = Date.from(base.getLastModifiedDate().get().toInstant(ZoneOffset.UTC));
		}

	}

}
