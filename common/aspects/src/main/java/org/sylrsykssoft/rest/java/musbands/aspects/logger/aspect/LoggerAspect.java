package org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging;

import lombok.extern.slf4j.Slf4j;

/**
 * Logs method calls.
 *
 * <p>
 * It is an AspectJ aspect and you are not supposed to use it directly. It is
 * instantiated by AspectJ runtime framework when your code is annotated with
 * {@link Logging} annotation.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Aspect
@Slf4j
public final class LoggerAspect {

	@Around("execution(@org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging * *.*(..))")
	public Object around(final ProceedingJoinPoint point) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = point.proceed();
		final Method method =
	            MethodSignature.class.cast(point.getSignature()).getMethod();
		LoggerHelper.log(method.getAnnotation(Logging.class).value(), "#%s(%s): %s in %[msec]s", method.getName(),
				point.getArgs(), result, System.currentTimeMillis() - start);
		return result;
	}
	
	
	private final static class LoggerHelper {
	    /**
	     * Log one line.
	     * @param level Level of logging
	     * @param log Destination log
	     * @param message Message to log
	     * @param params Message parameters
	     */
	    public static void log(final int level,
	        final String format, final Object... arguments) {
	    	switch (level) {
			case Logging.TRACE:
				if (enabled(level)) {
					LOGGER.trace(format, arguments);
					break;
				} else {
					log(Logging.DEBUG, format, arguments);
				}
			case Logging.DEBUG:
				if (enabled(level)) {
					LOGGER.debug(format, arguments);
					break;
				} else {
					log(Logging.WARN, format, arguments);
				}
			case Logging.WARN:
				if (enabled(level)) {
					LOGGER.warn(format, arguments);
					break;
				} else {
					log(Logging.ERROR, format, arguments);
				}
			case Logging.ERROR:
				if (enabled(level)) {
					LOGGER.error(format, arguments);
					break;
				} else {
					log(Logging.INFO, format, arguments);
				}
			case Logging.INFO:
			default:
				if (enabled(level)) {
					LOGGER.info(format, arguments);
				}
				break;
			}
	    }

	    /**
	     * Log level is enabled?
	     *
	     * @param level Level of logging
	     * @return TRUE if enabled
	     */
	    public static boolean enabled(final int level) {
	        boolean enabled;
	        switch (level) {
			case Logging.TRACE:
				enabled = LOGGER.isTraceEnabled();
				break;
			case Logging.DEBUG:
				enabled = LOGGER.isDebugEnabled();
				break;
			case Logging.WARN:
				enabled = LOGGER.isWarnEnabled();
				break;
			case Logging.ERROR:
				enabled = LOGGER.isErrorEnabled();
				break;
			case Logging.INFO:
			default:
				enabled = LOGGER.isInfoEnabled();
				break;
			}
	        return enabled;
	    }
	}
}
