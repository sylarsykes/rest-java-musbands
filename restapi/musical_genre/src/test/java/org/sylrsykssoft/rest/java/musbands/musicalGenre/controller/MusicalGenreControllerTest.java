package org.sylrsykssoft.rest.java.musbands.musicalGenre.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.sylrsykssoft.rest.java.musbands.configuration.configuration.ConfigurationConfiguration;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.service.MusicalGenreService;

/**
 * Musical genre controller test
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { ConfigurationConfiguration.class }, loader = AnnotationConfigContextLoader.class)
public class MusicalGenreControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	MusicalGenreController musicalGenreController;

	@Mock
	MusicalGenreService musicalGenreService;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(musicalGenreController).build();
	}

	@Test
	public void testFindAll() throws Exception {
		
//		when(musicalGenreService.findAll()).thenReturn(Arrays.asList(new MusicalGenreResource()));
		
		// call GET /admin/musicalGenres application/json
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/musicalGenres")
				.accept(MediaType.APPLICATION_JSON_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull("Empty list", result.getResponse());
	}
	
	public void testCreateMusicalGenre() {
		
	}
}
