package org.sylrsykssoft.rest.java.musbands.core.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;
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
 * Entity base.
 * 
 * @author juan.gonzalez.fernandez.jgf
 * 
 * https://github.com/spring-projects/spring-data-jpa/tree/master/src/main/java/org/springframework/data/jpa/repository/config
 *
 */
@MappedSuperclass()
@Data()
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter()
@Getter()
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true)
public class BaseEntity extends Base implements Persistable<Long> {

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	protected Long id;
	
	/**
	 * Builder.
	 * 
	 * @return BaseEntityBuilder
	 */
	public static BaseEntityBuilder builder() {
		return new BaseEntityBuilder();
	}
	
	/**
	 * Builder.
	 * 
	 * @param base BaseEntity base.
	 * 
	 * @return BaseEntityBuilder
	 */
	public static BaseEntityBuilder builder(final BaseEntity base) {
		return new BaseEntityBuilder(base);
	}
	

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.domain.Persistable#isNew()
	 */
	@Transient
	@Override
	public boolean isNew() {
		return null == getId();
	}
	
	/**
	 * Builder.
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	@Component()
	public static class BaseEntityBuilder extends BaseBuilder {
		
		/**
		 * Default constructor.
		 */
		public BaseEntityBuilder() {
			super();
		}
		
		/**
		 * 
		 * @param base BaseEntity object.
		 */
		public BaseEntityBuilder(final BaseEntity base) {
			super(base);
			this.id = base.id;
		}
	}
}
