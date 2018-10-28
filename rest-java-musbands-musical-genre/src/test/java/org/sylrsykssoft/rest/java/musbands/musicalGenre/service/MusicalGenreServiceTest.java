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
import org.sylrsykssoft.rest.java.musbands.core.configuration.CoreCacheConfiguration;
import org.sylrsykssoft.rest.java.musbands.core.configuration.CoreConfiguration;
import org.sylrsykssoft.rest.java.musbands.core.configuration.CoreDomainConfiguration;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.RestJavaMusbandsMusicalGenreApplication;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration.BaseConfiguration;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration.CacheConfiguration;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration.DomainConfiguration;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre.MusicalGenreBuilder;

/**
 * Musical genre service test.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RestJavaMusbandsMusicalGenreApplication.class })
@ContextConfiguration(classes = { CoreConfiguration.class, CoreDomainConfiguration.class, CoreCacheConfiguration.class,
		BaseConfiguration.class, DomainConfiguration.class,
		CacheConfiguration.class }, loader = AnnotationConfigContextLoader.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MusicalGenreServiceTest {

	@Autowired
	MusicalGenreService musicalGenreService;

	MusicalGenre domain;
	
	@Autowired
	MusicalGenreBuilder builder;

	@Before
	public void setUp() {
		String name = "Pop punk";
		String description = "Pop punk (also known as punk-pop) is a music genre that fuses elements of pop music with punk rock. Fast tempos, loud electric guitar distortion, and power chord changes are typically played under pop-influenced melodies, vocal styles with lighthearted lyrical themes including boredom and teenage romance.";

		domain = builder.name(name).description(description).build();
	}

	@Test
	public void testCreateMusicalGenre() {
		final MusicalGenre musicalGenreSaved = musicalGenreService.save(domain);

		Assert.assertNotNull(musicalGenreSaved);
	}
	
	@Test
	public void testFindAllMusicalGenres() {
		Iterable<MusicalGenre> musicalGenres = musicalGenreService.findAll();
		Assert.assertNotNull(musicalGenres);
		
//		assertThat(musicalGenres, is(not()));
	}

}
