package org.sylrsykssoft.rest.java.musbands.core.listener;

import java.util.Locale;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.StringUtils;
import org.sylrsykssoft.rest.java.musbands.core.domain.ITranslatable;
import org.sylrsykssoft.rest.java.musbands.core.domain.Translate;

/**
 * Translate listener.
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
	void onPrePersist(final Object translatebleObject) {
		if (translatebleObject instanceof ITranslatable) {
			Translate translate = getTranslatable((ITranslatable) translatebleObject);

			if (StringUtils.isEmpty(translate.getLocale())) {
				translate.setLocale(Locale.UK.getLanguage());
			}
		}
	}
	
	/**
	 * Assign locale.
	 * 
	 * @param base
	 */
	@PreUpdate
	void onPreUpdate(final Object translatebleObject) {
		if (translatebleObject instanceof ITranslatable) {
			Translate translate = getTranslatable((ITranslatable) translatebleObject);
			
			if (StringUtils.isEmpty(translate.getLocale())) {
				translate.setLocale(Locale.UK.getLanguage());
			}
		}
	}

	/**
	 * Getter audit
	 * 
	 * @param auditableObject
	 * @return
	 */
	private Translate getTranslatable(final ITranslatable translatableObject) {
		Translate translate = translatableObject.getTranslate();
		if (translate == null) {
			translate = new Translate();
			translatableObject.setTranslate(translate);
		}
		return translate;
	}
}
