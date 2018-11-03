package org.sylrsykssoft.rest.java.musbands.core.exception;

public final class AppException extends Exception {
	private static final long serialVersionUID = 2363674934985036006L;

	public AppException() {
		super();
	}

	public AppException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public AppException(final String message) {
		super(message);
	}

	public AppException(final Throwable cause) {
		super(cause);
	}
}
