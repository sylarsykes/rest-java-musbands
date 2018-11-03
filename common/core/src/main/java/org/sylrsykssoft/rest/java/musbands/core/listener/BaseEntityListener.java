package org.sylrsykssoft.rest.java.musbands.core.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.sylrsykssoft.rest.java.musbands.core.domain.Base;

/**
 * Base entity entity listener.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class BaseEntityListener {
	/**
	 * Assign createdAt
	 */
	@PrePersist()
	void onPrePersist(final Base base) {
		Date date = new Date();
		base.setCreatedAt(date);
	}

	/**
	 * Assign updatedAt
	 */
	@PreUpdate()
	void onPreUpdate(final Base base) {
		Date date = new Date();
		base.setUpdatedAt(date);
	}

	/**
	 * Assign deletedAt
	 */
	@PreRemove()
	void onPreDelete(final Base base) {
		Date date = new Date();
		base.setDeletedAt(date);
	}
}
