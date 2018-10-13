package org.sylrsykssoft.rest.java.musbands.core.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseEntityResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseEntity;
import org.sylrsykssoft.rest.java.musbands.core.exception.AppException;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotFoundEntityException;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotIdMismatchEntityException;
import org.sylrsykssoft.rest.java.musbands.core.service.BaseEntityService;

import lombok.extern.slf4j.Slf4j;

/**
 * Base controller
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <R> Resource class
 * @param <T> Entity class
 */
@Slf4j()
public class BaseController<R extends BaseEntityResource, T extends BaseEntity> {

	@Autowired()
	protected BaseEntityService<T> service;

	/**
	 * Find all entries.
	 * 
	 * @return Iterable<T> entries.
	 * 
	 * @throws NotFoundEntityException
	 */
	@GetMapping("")
	public Iterable<T> findAll() throws NotFoundEntityException {
		LOGGER.info("BaseController:findAll Finding all entries");

		final Iterable<T> entities = service.findAll();
		if (entities == null) {
			throw new NotFoundEntityException();
		}

		LOGGER.info("BaseController:findAll Found {} entries.", entities);

		return entities;
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
	@GetMapping("/{id}")
	public Optional<T> findOne(@PathVariable final Long id) throws NotFoundEntityException {
		LOGGER.info("BaseController:findOne Find entry with id {}", id);
		final Optional<T> entity = service.findById(id);

		if (entity == null) {
			throw new NotFoundEntityException();
		}

		LOGGER.info("BaseController:findOne Found {} entry.", entity);
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
	@PutMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public T create(@RequestBody final T entity) {
		LOGGER.info("BaseController:create Creating a new todo entry by using information: {}", entity);

		final T created = service.save(entity);

		LOGGER.info("BaseController:create Created a new todo entry: {}", created);

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
	@PutMapping("/{id}")
	public T update(@RequestBody final T entity, @PathVariable final Long id)
			throws NotIdMismatchEntityException, NotFoundEntityException {
		LOGGER.info("BaseController:update Updating a entry with id: {}", id);

		if (entity.getId() != id) {
			throw new NotIdMismatchEntityException();
		}

		final Optional<T> old = service.findById(id);
		if (old == null) {
			throw new NotFoundEntityException();
		}

		final T updated = service.save(entity);

		LOGGER.info("BaseController:update Updated the entry: {}", updated);

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
	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Long id) throws NotFoundEntityException, AppException {
		LOGGER.info("BaseController:delete Deleting a entry with id: {}", id);

		final Optional<T> old = service.findById(id);
		if (old == null) {
			throw new NotFoundEntityException();
		}

		try {
			service.deleteById(id);
		} catch (Exception e) {
			throw new AppException();
		}
	}

}
