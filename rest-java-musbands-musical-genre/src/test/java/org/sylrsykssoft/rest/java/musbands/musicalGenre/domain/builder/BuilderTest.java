package org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.RestJavaMusbandsMusicalGenreApplication;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre.MusicalGenreBuilder;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
		RestJavaMusbandsMusicalGenreApplication.class })
public class BuilderTest {

	@Autowired
	private BeanFactory beanFactory;
	

	@Before
	public void setUp() {

	}

	@Test
	public void testMusicalGenreBuilder() {
		String name = "Pop punk";
		String description = "Pop punk (also known as punk-pop) is a music genre that fuses elements of pop music with punk rock. Fast tempos, loud electric guitar distortion, and power chord changes are typically played under pop-influenced melodies, vocal styles with lighthearted lyrical themes including boredom and teenage romance.";

		MusicalGenreBuilder builder = null;
		MusicalGenre domain = new MusicalGenre();
		try {
			builder = (MusicalGenreBuilder) beanFactory.getBean("createMusicalGenreBuilder", domain);
		} catch (Exception e) {
			Assert.fail("Error in execute musical genre builder");
		}

		Assert.assertNotNull(builder);

		domain = builder.name(name).description(description).build();

		Assert.assertNotNull(domain);
	}
}
