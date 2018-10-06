package org.sylrsykssoft.rest.java.musbands.audit.domain;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface IAuditable {

	/**
	 * Getter audit
	 * 
	 * @return Audit
	 */
	Audit getAudit();
	
	/**
	 * Setter audit
	 * 
	 * @param audit
	 */
	void setAudit(final Audit audit);
}
