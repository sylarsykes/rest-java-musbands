package org.sylrsykssoft.rest.java.musbands.aspects.logger.aspect;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.sylrsykssoft.rest.java.musbands.aspects.RestJavaMusbandsAspectsApplication;
import org.sylrsykssoft.rest.java.musbands.aspects.configuration.BaseConfiguration;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging;

import lombok.Data;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RestJavaMusbandsAspectsApplication.class })
@ContextConfiguration(classes = { BaseConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public class TestLoggerAspect {

	private Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

	private DummyService dummyService;

	@Autowired
	ApplicationContext context;

	@Before
	public void setUp() {
		dummyService = new DummyService();
		context.getBeansOfType(LoggerAspect.class);
	}

	@Test
	public void baseTest() throws Throwable {

		ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class, RETURNS_DEEP_STUBS);
		LoggerAspect aspect = new LoggerAspect(logger);

		// calling logic to be tested
		Object actualReturnedValue = aspect.log(proceedingJoinPoint);

		assertNotNull(actualReturnedValue);
	}

	@Test
	public void testCreateDummyService() {

		DummyUser user = dummyService.create();

		assertNotNull(user);

	}

	@Service
	@Logging(Logging.INFO)
	private class DummyService {

		@Logging(Logging.INFO)
		public DummyUser create() {
			DummyUser user = new DummyUser();
			user.setName("Juan");
			user.setSurname("Glez. Fdez.");
			return user;
		}
	}

	@Data
	private class DummyUser {
		private String name;
		private String surname;
	}
}
