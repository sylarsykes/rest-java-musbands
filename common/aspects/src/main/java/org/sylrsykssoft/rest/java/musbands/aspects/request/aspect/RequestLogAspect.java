package org.sylrsykssoft.rest.java.musbands.aspects.request.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect.Loggable;

import lombok.extern.slf4j.Slf4j;

/**
 * RequestLogAspect
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Aspect
@Component
@Slf4j
public class RequestLogAspect implements Loggable {

	/**
	 * Log request.
	 * 
	 * @param proceedingJoinPoint
	 * @return Object
	 * @throws Throwable
	 */
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(public * *(..))")
	public Object log(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		Object value;

		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throw throwable;
		} finally {
			LOGGER.info("{} {} from {}", request.getMethod(), request.getRequestURI(), request.getRemoteAddr(),
					request.getHeader("user-id"));
		}

		return value;
	}
}
