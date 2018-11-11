package org.sylrsykssoft.rest.java.musbands.musicalGenre.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import java.util.Optional;

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
 * Musical genre service test.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RestJavaMusbandsMusicalGenreApplication.class })
@ContextConfiguration(classes = { 
		ConfigurationConfiguration.class }, loader = AnnotationConfigContextLoader.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		String name = "Pop punk";
		final MusicalGenreResource musicalGenreSaved = musicalGenreService.save(domain);

		assertThat("Entity did not get an generated Id!", musicalGenreSaved.getID(), greaterThan(-1));
        assertThat("Entity name did not match!", musicalGenreSaved.getName(), is(name));
		
	}
	
	@Test
	public void testFindAllMusicalGenres() {
		Iterable<MusicalGenreResource> musicalGenres = musicalGenreService.findAll();
		Assert.assertNotNull(musicalGenres);
	}
	
	@Test
	public void testUpdateMusicalGenre() {
		String name = "Pop punk";
		Optional<MusicalGenreResource> optResource = musicalGenreService.findByName(name);
		
		MusicalGenreResource resourceGet = optResource.orElseThrow(IllegalStateException::new);
		
		assertThat("Entity name did not match!", resourceGet.getName(), is(name));
		
		MusicalGenreResource resourceUpdated = musicalGenreService.save(resourceBuilder.id(resourceGet.getID()).name(resourceGet.getName())
				.description(resourceGet.getDescription() + " El ir.").build());
		
		assertThat("Entity id did not match!", resourceUpdated.getID(), is(resourceGet.getID()));
	}
	
	@Test
	public void testDeleteMusicalGenre() {
		String name = "Pop punk";
		Optional<MusicalGenreResource> optResource = musicalGenreService.findByName(name);
		
		MusicalGenreResource source = optResource.orElseThrow(IllegalStateException::new);
		
		assertThat("Entity name did not match!", source.getName(), is(name));
		
		musicalGenreService.delete(source);
	}

}
