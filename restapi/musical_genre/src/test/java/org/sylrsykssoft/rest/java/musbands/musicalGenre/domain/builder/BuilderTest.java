package org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.sylrsykssoft.rest.java.musbands.configuration.configuration.ConfigurationConfiguration;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.RestJavaMusbandsMusicalGenreApplication;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource.MusicalGenreResourceBuilder;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
		RestJavaMusbandsMusicalGenreApplication.class })
@ContextConfiguration(classes = { ConfigurationConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public class BuilderTest {

	@Autowired
	MusicalGenreResourceBuilder resourceBuilder;
	
	MusicalGenreResource domain;
	

	@Before
	public void setUp() {

	}

	@Test
	public void testMusicalGenreBuilder() {
		String name = "Pop punk";
		String description = "Pop punk (also known as punk-pop) is a music genre that fuses elements of pop music with punk rock. Fast tempos, loud electric guitar distortion, and power chord changes are typically played under pop-influenced melodies, vocal styles with lighthearted lyrical themes including boredom and teenage romance.";

		Assert.assertNotNull(resourceBuilder);

		domain = resourceBuilder.name(name).description(description).build();

		Assert.assertNotNull(domain);
	}
}
