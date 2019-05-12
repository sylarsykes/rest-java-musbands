package org.sylrsykssoft.rest.java.musbands.core.exception;

import java.beans.ConstructorProperties;

/**
 * Common application exception
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
public final class AppException extends Exception {
	private static final long serialVersionUID = 2363674934985036006L;

	/**
	 * Deafult constructor
	 */
	public AppException() {
		super();
	}

	/**
	 * Message constructor 
	 * 
	 * @param message
	 */
	@ConstructorProperties({ "message"})
	public AppException(final String message) {
		super(message);
	}
	
	/**
	 * Cause constructor
	 * 
	 * @param cause
	 */
	@ConstructorProperties({ "cause"})
	public AppException(final Throwable cause) {
		super(cause);
	}
	
	/**
	 * AllArgsConstructor
	 * 
	 * @param message
	 * @param cause
	 */
	@ConstructorProperties({ "message", "cause"})
	public AppException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
