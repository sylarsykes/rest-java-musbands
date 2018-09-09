package org.sylrsykssoft.rest.java.musbands.core.exception;

public final class NotFoundEntityException extends RuntimeException {
	private static final long serialVersionUID = 2363674934985036006L;

	public NotFoundEntityException() {
		super();
	}

	public NotFoundEntityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NotFoundEntityException(final String message) {
		super(message);
	}

	public NotFoundEntityException(final Throwable cause) {
		super(cause);
	}
}
