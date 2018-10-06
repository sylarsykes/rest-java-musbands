package org.sylrsykssoft.rest.java.musbands.audit.domain.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.sylrsykssoft.rest.java.musbands.audit.domain.Audit;
import org.sylrsykssoft.rest.java.musbands.audit.domain.IAuditable;

/**
 * Audit listener
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class AuditListener {

	/**
	 * Set audit
	 * 
	 * @param auditableObject
	 */
	@PrePersist
	void onPrePersist(final Object auditableObject) {
		if (auditableObject instanceof IAuditable) {
			Audit audit = getAudit((IAuditable) auditableObject);
			
			Date date = new Date();
			audit.setCreatedAt(date);
			
			String username = getUsername();
			audit.setCreatedBy(username);
		}
	}

	/**
	 * Set audit
	 * 
	 * @param auditableObject
	 */
	@PreUpdate
	void onPreUpdate(final Object auditableObject) {
		if (auditableObject instanceof IAuditable) {
			Audit audit = getAudit((IAuditable) auditableObject);
			
			Date date = new Date();
			audit.setUpdatedAt(date);
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();
			audit.setLastModifiedBy(username);
		}
	}
	
	/**
	 * Set audit
	 * 
	 * @param auditableObject
	 */
	@PreRemove
	void onPreDelete(final Object auditableObject) {
		if (auditableObject instanceof IAuditable) {
			Audit audit = getAudit((IAuditable) auditableObject);
			
			Date date = new Date();
			audit.setDeletedAt(date);
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();
			audit.setLastModifiedBy(username);
		}
	}

	/**
	 * Get username
	 * 
	 * @return Optional<String>
	 */
	private String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = (auth != null)? auth.getName() : "adminTest";
		return username;
	}
	
	/**
	 * 
	 * 
	 * @param auditableObject
	 * @return
	 */
	private Audit getAudit(IAuditable auditableObject) {
		Audit audit = auditableObject.getAudit();
		if (audit == null) {
			audit = new Audit();
			auditableObject.setAudit(audit);
		}
		return audit;
	}
	
}
