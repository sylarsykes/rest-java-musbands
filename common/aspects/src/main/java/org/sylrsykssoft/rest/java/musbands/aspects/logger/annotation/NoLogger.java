package org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Class and method level annotation to turn off automatic logging.
 * Adding it to class or method disables logging for it. 
 * Annotation on method takes precedence over that on class.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface NoLogger {

}
