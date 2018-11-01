package org.sylrsykssoft.rest.java.musbands.musicalGenre.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.sylrsykssoft.rest.java.musbands.core.controller.BaseAdminController;
import org.sylrsykssoft.rest.java.musbands.core.exception.AppException;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotFoundEntityException;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotIdMismatchEntityException;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.service.MusicalGenreService;

import lombok.extern.slf4j.Slf4j;

/**
 * Rest Controller for Musical Genre API
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RestController
@Slf4j()
public class MusicalGenreController extends BaseAdminController<MusicalGenreResource, MusicalGenre> {

	@Autowired
	private MusicalGenreService musicalGenreService;
	
	/**
	 * Get all musical genres
	 * 
	 * @return
	 * @throws NotFoundEntityException
	 */
	@GetMapping("/admin/musicalGenres")
	@ResponseBody
	public List<MusicalGenreResource> findAll() throws NotFoundEntityException {
		LOGGER.info("MusicalGenreController:findAll Finding all entries");
		
		List<MusicalGenreResource> result = musicalGenreService.findAll();
		if (result == null) {
			throw new NotFoundEntityException();
		}

		LOGGER.info("MusicalGenreController:findAll Found {} entries.", result);
		
		return result;
	}
	
	/**
	 * Find by name.
	 * 
	 * @param name
	 *            Value of attribute name.
	 * 
	 * @return T entity.
	 * 
	 * @throws NotFoundEntityException
	 */
	@GetMapping(path = "/admin/musicalGenres/{name}")
	@ResponseBody
	public Optional<MusicalGenreResource> findByName(@PathVariable final String name) throws NotFoundEntityException {
		LOGGER.info("BaseAdminController:findByName name {}", name);
		
		Optional<MusicalGenreResource> result = musicalGenreService.findByName(name);
		if (result == null) {
			throw new NotFoundEntityException();
		}
		
		LOGGER.info("BaseAdminController:findByName Found {}", result);
		
		return result;
	}

	/**
	 * Find one entry.
	 * 
	 * @param id
	 *            Id
	 * 
	 * @return T entry.
	 * 
	 * @throws NotFoundEntityException
	 */
	@GetMapping("/admin/musicalGenres/{id}")
	public Optional<MusicalGenreResource> findOne(@PathVariable final Integer id) throws NotFoundEntityException {
		LOGGER.info("MusicalGenreController:findOne Find entry with id {}", id);
		final Optional<MusicalGenreResource> entity = musicalGenreService.findById(id);

		if (entity == null) {
			throw new NotFoundEntityException();
		}

		LOGGER.info("MusicalGenreController:findOne Found {} entry.", entity);
		return entity;
	}

	/**
	 * Create entry.
	 * 
	 * @param entity
	 *            Entity.
	 * 
	 * @return T entity.
	 */
	@PutMapping("/admin/musicalGenres")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MusicalGenreResource create(@Valid @RequestBody final MusicalGenreResource entity) {
		LOGGER.info("MusicalGenreController:create Creating a new todo entry by using information: {}", entity);

		final MusicalGenreResource created = musicalGenreService.save(entity);

		LOGGER.info("MusicalGenreController:create Created a new todo entry: {}", created);

		return created;
	}

	/**
	 * Update entity.
	 * 
	 * @param entity
	 *            Entity.
	 * @param id
	 *            Id.
	 * 
	 * @return T entity.
	 * 
	 * @throws NotIdMismatchEntityException
	 * @throws NotFoundEntityException
	 */
	@PutMapping("/admin/musicalGenres/{id}")
	public MusicalGenreResource update(@Valid @RequestBody final MusicalGenreResource entity, final @PathVariable Integer id)
			throws NotIdMismatchEntityException, NotFoundEntityException {
		LOGGER.info("MusicalGenreController:update Updating a entry with id: {}", id);

		if (ObjectUtils.notEqual(entity.getID(), id)) {
			throw new NotIdMismatchEntityException();
		}
		
		final MusicalGenreResource updated = musicalGenreService.save(entity);

		LOGGER.info("MusicalGenreController:update Updated the entry: {}", updated);

		return updated;
	}

	/**
	 * Delete entry.
	 * 
	 * @param id
	 *            Id.
	 * 
	 * @throws NotFoundEntityException
	 * @throws AppException
	 */
	@DeleteMapping("/admin/musicalGenres/{id}")
	public void delete(@PathVariable final Integer id) throws NotFoundEntityException, AppException {
		LOGGER.info("MusicalGenreController:delete Deleting a entry with id: {}", id);

		try {
			musicalGenreService.deleteById(id);
		} catch (Exception e) {
			throw new AppException();
		}
	}
	
}
