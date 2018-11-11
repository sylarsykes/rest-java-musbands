package org.sylrsykssoft.rest.java.musbands.audit.domain.listener;

import java.util.Date;

import javax.persistence.PreUpdate;

import org.sylrsykssoft.rest.java.musbands.audit.domain.BaseAdminAudit;

/**
 * BaseAdminAuditListener
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class BaseAdminAuditListener {

	
	/**
	 * 
	 */
	@PreUpdate
	void onPreRemove(final BaseAdminAudit audit) {
		Date today = new Date();
		audit.setRemovedAt(today);
	}
}
