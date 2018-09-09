package org.sylrsykssoft.rest.java.musbands.core;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.sylrsykssoft.rest.java.musbands.core.RestJavaMusbandsCoreApplication;
import org.sylrsykssoft.rest.java.musbands.core.configuration.CoreCacheConfiguration;
import org.sylrsykssoft.rest.java.musbands.core.configuration.CoreConfiguration;
import org.sylrsykssoft.rest.java.musbands.core.configuration.CoreDomainConfiguration;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { RestJavaMusbandsCoreApplication.class })
@ContextConfiguration(classes = { CoreConfiguration.class, CoreDomainConfiguration.class, CoreCacheConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public class CoreTest {

}
