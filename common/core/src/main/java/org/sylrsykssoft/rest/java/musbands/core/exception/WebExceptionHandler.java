package org.sylrsykssoft.rest.java.musbands.core.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * WebExceptionHandler
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@ControllerAdvice()
public final class WebExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Default constructor.
	 */
	public WebExceptionHandler() {
		super();
	}

	/**
	 * Handler to not found entity.
	 * 
	 * @param ex Exception
	 * @param request Request
	 * 
	 * @return ResponseEntity<Object> response.
	 */
	@ExceptionHandler({ NotFoundEntityException.class })
	protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex, "Entity not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	/**
	 * Handler to bad request.
	 * 
	 * @param ex Exception
	 * @param request Request
	 * 
	 * @return ResponseEntity<Object> response.
	 */
	@ExceptionHandler({ NotIdMismatchEntityException.class, ConstraintViolationException.class,
			DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
