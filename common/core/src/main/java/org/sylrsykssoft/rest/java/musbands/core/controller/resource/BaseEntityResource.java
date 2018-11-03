/**
 * 
 */
package org.sylrsykssoft.rest.java.musbands.core.controller.resource;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO BaseEntity.
 * 
 * @author juan.gonzalez.fernandez.jgf
 * 
 * https://github.com/eugenp/tutorials/blob/master/spring-security-rest/src/main/java/org/baeldung/persistence/model/Customer.java
 * 
 * http://www.baeldung.com/spring-hateoas-tutorial
 *
 */
@Data()
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter()
@Getter()
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class BaseEntityResource extends BaseResource {

	protected Long ID;
	
	/**
	 * Builder.
	 * 
	 * @return BaseEntityBuilder
	 */
	public static BaseEntityResourceBuilder builder() {
		return new BaseEntityResourceBuilder();
	}
	
	/**
	 * Builder.
	 * 
	 * @param base BaseEntity base.
	 * 
	 * @return BaseEntityBuilder
	 */
	public static BaseEntityResourceBuilder builder(final BaseEntityResource base) {
		return new BaseEntityResourceBuilder(base);
	}
	
	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class BaseEntityResourceBuilder extends BaseResourceBuilder {
		
		/**
		 * Default constructor.
		 */
		public BaseEntityResourceBuilder() {
			super();
		}
		
		/**
		 * 
		 * @param base BaseEntity object.
		 */
		public BaseEntityResourceBuilder(final BaseEntityResource base) {
			super(base);
			this.ID = base.ID;
		}
	}
}
