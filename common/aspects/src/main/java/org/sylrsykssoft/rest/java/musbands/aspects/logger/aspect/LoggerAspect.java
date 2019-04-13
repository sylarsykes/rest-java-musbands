package org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect;

import java.beans.ConstructorProperties;
import java.lang.reflect.Method;

import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging;

import lombok.NonNull;

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
public class LoggerAspect implements Loggable {

	@NonNull
	private Logger LOGGER;

	/**
	 * Default constructor
	 */
	public LoggerAspect() {
		this(LoggerFactory.getLogger(LoggerAspect.class));
	}

	/**
	 * Constructor
	 * 
	 * @param LOGGER
	 */
	@ConstructorProperties({ "LOGGER" })
	public LoggerAspect(final @NonNull Logger LOGGER) {
		this.LOGGER = LOGGER;
	}

	@Pointcut("@annotation(org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging) "
			+ "|| @target(org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging)")
	public void methodOrClassLoggingEnabledPointcut() {
	}

	@Pointcut("!@annotation(org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.NoLogging)")
	public void methodLoggingNotDisabledPointcut() {
	}

	/**
	 * Logging method
	 * 
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	@Override
	@Around("methodLoggingNotDisabledPointcut() && methodOrClassLoggingEnabledPointcut()")
	@Nullable
	public Object log(final @NonNull ProceedingJoinPoint point) throws Throwable {
		final StopWatch timer = new StopWatch();
		Object result = null;
		Method method = null;
		Signature signature = null;

		try {
			timer.start();
			signature = point.getSignature();
			result = point.proceed();

			if (signature instanceof MethodSignature) {
				method = ((MethodSignature) signature).getMethod();
			}

		} catch (Exception e) {
			LOGGER.error("Exception occurred in pre-proceed logic", e);
		} finally {
			timer.stop();
			int level = Logging.INFO;

			if (method != null) {
				level = method.getAnnotation(Logging.class).value();
			}

			LoggerHelper.log(LOGGER, level, "#%s(%s): %s in %[msec]s", signature.getName(), point.getArgs(), result, timer.getTime());
		}

		return result;
	}

	/**
	 * 
	 * 
	 * @param joinPoint
	 * @param t
	 */
	@AfterThrowing(pointcut = "methodLoggingNotDisabledPointcut() && methodOrClassLoggingEnabledPointcut()", throwing = "t")
	public void onException(@NonNull JoinPoint joinPoint, @NonNull Throwable t) {
		String methodName = joinPoint.getSignature().getName() + "()";
		LOGGER.info(methodName + " threw exception: [" + t + "]");
	}

	/**
	 * LoggerHelper
	 * 
	 * @author juan.gonzalez.fernandez.jgf
	 *
	 */
	private final static class LoggerHelper {
		/**
		 * Log one line.
		 * 
		 * @param level   Level of logging
		 * @param log     Destination log
		 * @param message Message to log
		 * @param params  Message parameters
		 */
		public static void log(final Logger logger, final int level, final String format, final Object... arguments) {
			switch (level) {
			case Logging.TRACE:
				if (enabled(logger, level)) {
					logger.trace(format, arguments);
					break;
				} else {
					log(logger, Logging.DEBUG, format, arguments);
				}
			case Logging.DEBUG:
				if (enabled(logger, level)) {
					logger.debug(format, arguments);
					break;
				} else {
					log(logger, Logging.WARN, format, arguments);
				}
			case Logging.WARN:
				if (enabled(logger, level)) {
					logger.warn(format, arguments);
					break;
				} else {
					log(logger, Logging.ERROR, format, arguments);
				}
			case Logging.ERROR:
				if (enabled(logger, level)) {
					logger.error(format, arguments);
					break;
				} else {
					log(logger, Logging.INFO, format, arguments);
				}
			case Logging.INFO:
			default:
				if (enabled(logger, level)) {
					logger.info(format, arguments);
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
		public static boolean enabled(final Logger logger, final int level) {
			boolean enabled;
			switch (level) {
			case Logging.TRACE:
				enabled = logger.isTraceEnabled();
				break;
			case Logging.DEBUG:
				enabled = logger.isDebugEnabled();
				break;
			case Logging.WARN:
				enabled = logger.isWarnEnabled();
				break;
			case Logging.ERROR:
				enabled = logger.isErrorEnabled();
				break;
			case Logging.INFO:
			default:
				enabled = logger.isInfoEnabled();
				break;
			}
			return enabled;
		}
	}
}
