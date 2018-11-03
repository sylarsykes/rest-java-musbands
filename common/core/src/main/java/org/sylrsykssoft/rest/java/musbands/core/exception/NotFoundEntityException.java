package org.sylrsykssoft.rest.java.musbands.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
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
