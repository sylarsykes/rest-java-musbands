package org.sylrsykssoft.rest.java.musbands.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public final class NotIdMismatchEntityException extends RuntimeException {

	private static final long serialVersionUID = 6753504484000665575L;

	public NotIdMismatchEntityException() {
		super();
	}

	public NotIdMismatchEntityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public NotIdMismatchEntityException(final String message) {
		super(message);
	}

	public NotIdMismatchEntityException(final Throwable cause) {
		super(cause);
	}
}
