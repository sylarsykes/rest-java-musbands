package org.sylrsykssoft.rest.java.musbands.musicalGenre.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging;
import org.sylrsykssoft.rest.java.musbands.core.controller.BaseAdminController;
import org.sylrsykssoft.rest.java.musbands.core.exception.AppException;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotFoundEntityException;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotIdMismatchEntityException;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.service.MusicalGenreService;

/**
 * Rest Controller for Musical Genre API
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RestController
@Logging(Logging.INFO)
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
		final List<MusicalGenreResource> result = musicalGenreService.findAll();
		if (result == null) {
			throw new NotFoundEntityException();
		}

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
	public MusicalGenreResource findByName(@PathVariable final String name) throws NotFoundEntityException {
		final Optional<MusicalGenreResource> result = musicalGenreService.findByName(name);
		return result.get();
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
	@ResponseBody
	public MusicalGenreResource findOne(@PathVariable final Integer id) throws NotFoundEntityException {
		final Optional<MusicalGenreResource> result = musicalGenreService.findById(id);
		return result.get();
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
	@ResponseBody
	public MusicalGenreResource create(@Valid @RequestBody final MusicalGenreResource entity) {
		return musicalGenreService.save(entity);
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
	@ResponseBody
	public MusicalGenreResource update(@Valid @RequestBody final MusicalGenreResource entity, final @PathVariable Integer id)
			throws NotIdMismatchEntityException, NotFoundEntityException {

		if (ObjectUtils.notEqual(entity.getID(), id)) {
			throw new NotIdMismatchEntityException();
		}
		
		return musicalGenreService.save(entity);
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
		try {
			musicalGenreService.deleteById(id);
		} catch (Exception e) {
			throw new AppException();
		}
	}
	
}
