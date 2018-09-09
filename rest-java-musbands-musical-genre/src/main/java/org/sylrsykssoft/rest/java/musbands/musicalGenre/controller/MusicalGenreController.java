package org.sylrsykssoft.rest.java.musbands.musicalGenre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.sylrsykssoft.rest.java.musbands.core.controller.BaseAdminController;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.service.MusicalGenreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j()
public class MusicalGenreController extends BaseAdminController<MusicalGenreResource, MusicalGenre> {

	@Autowired()
	public MusicalGenreService adminService;
	
}
