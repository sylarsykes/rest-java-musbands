package org.sylrsykssoft.rest.java.musbands.musicalGenre.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
 * Musical genre service test.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RestJavaMusbandsMusicalGenreApplication.class })
@ContextConfiguration(classes = { 
		ConfigurationConfiguration.class }, loader = AnnotationConfigContextLoader.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MusicalGenreServiceTest {

	@Autowired
	MusicalGenreService musicalGenreService;

	MusicalGenreResource domain;
	
	@Autowired
	MusicalGenreResourceBuilder resourceBuilder;

	@Before
	public void setUp() {
		String name = "Pop punk";
		String description = "Pop punk (also known as punk-pop) is a music genre that fuses elements of pop music with punk rock. Fast tempos, loud electric guitar distortion, and power chord changes are typically played under pop-influenced melodies, vocal styles with lighthearted lyrical themes including boredom and teenage romance.";

		domain = resourceBuilder.name(name).description(description).build();
	}

	@Test
	public void testCreateMusicalGenre() {
		final MusicalGenreResource musicalGenreSaved = musicalGenreService.save(domain);

		Assert.assertNotNull(musicalGenreSaved);
	}
	
	@Test
	public void testFindAllMusicalGenres() {
		Iterable<MusicalGenreResource> musicalGenres = musicalGenreService.findAll();
		Assert.assertNotNull(musicalGenres);
	}

}
