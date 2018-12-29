package org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.NonNull;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public interface Loggable {

	/**
	 * Log method or class
	 * 
	 * @param point
	 * @return Object
	 * @throws Throwable
	 */
	Object log(final @NonNull ProceedingJoinPoint point) throws Throwable;
}
