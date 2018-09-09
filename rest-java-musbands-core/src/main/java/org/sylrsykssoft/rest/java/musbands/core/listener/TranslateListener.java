package org.sylrsykssoft.rest.java.musbands.core.listener;

import java.util.Locale;

import javax.persistence.PrePersist;

import org.apache.commons.lang3.StringUtils;
import org.sylrsykssoft.rest.java.musbands.core.domain.Translate;

/**
 * BaseAdminTranslatable entity entity listener.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public class TranslateListener {

	/**
	 * Assign locale.
	 * 
	 * @param base
	 */
	@PrePersist
	void onPrePersist(final Translate base) {
		if (StringUtils.isEmpty(base.getLocale())) {
			base.setLocale(Locale.UK.getLanguage());
		}
	}
}
