package org.sylrsykssoft.rest.java.musbands.core.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;

import org.springframework.stereotype.Component;
import org.sylrsykssoft.rest.java.musbands.core.listener.TranslateListener;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity translatable
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
@EntityListeners(TranslateListener.class)
public class Translate {

	@Column(name = "locale", nullable = false, unique = true, length = 3)
	protected String locale;

	/**
	 * Builder.
	 * 
	 * @return TranslateBuilder
	 */
	public static TranslateBuilder builder() {
		return new TranslateBuilder();
	}

	/**
	 * Builder.
	 * 
	 * @param translate.
	 * 
	 * @return TranslateBuilder
	 */
	public static TranslateBuilder builder(final Translate translate) {
		return new TranslateBuilder(translate);
	}

	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class TranslateBuilder {

		/**
		 * Default constructor.
		 */
		public TranslateBuilder() {
			super();
		}

		/**
		 * 
		 * @param translate.
		 */
		public TranslateBuilder(final Translate translate) {
			this.locale = translate.getLocale();
		}
	}
}
