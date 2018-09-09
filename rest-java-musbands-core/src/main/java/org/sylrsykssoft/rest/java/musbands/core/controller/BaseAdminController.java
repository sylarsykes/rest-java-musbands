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
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseAdminResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;
import org.sylrsykssoft.rest.java.musbands.core.exception.AppException;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotFoundEntityException;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotIdMismatchEntityException;
import org.sylrsykssoft.rest.java.musbands.core.service.BaseAdminService;

import lombok.extern.slf4j.Slf4j;

@Slf4j()
public class BaseAdminController<R extends BaseAdminResource, T extends BaseAdmin> {

	@Autowired()
	protected BaseAdminService<T> adminService;

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
	@GetMapping(path = "/{name}")
	public Optional<T> findByName(@PathVariable final String name) throws NotFoundEntityException {
		LOGGER.info("BaseAdminController:findByName name {}", name);

		final Optional<T> entity = adminService.findByName(name);
		if (entity == null) {
			throw new NotFoundEntityException();
		}

		LOGGER.info("BaseAdminController:findByName Found {}", entity);

		return entity;
	}

	/**
	 * Find all entries.
	 * 
	 * @return Iterable<T> entries.
	 * 
	 * @throws NotFoundEntityException
	 */
	@GetMapping()
	public Iterable<T> findAll() throws NotFoundEntityException {
		LOGGER.info("BaseController:findAll Finding all entries");

		final Iterable<T> entities = adminService.findAll();
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
	public Optional<T> findOne(@PathVariable final Integer id) throws NotFoundEntityException {
		LOGGER.info("BaseController:findOne Find entry with id {}", id);
		final Optional<T> entity = adminService.findById(id);

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
	@PutMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public T create(@RequestBody final T entity) {
		LOGGER.info("BaseController:create Creating a new todo entry by using information: {}", entity);

		final T created = adminService.save(entity);

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
	public T update(@RequestBody final T entity, @PathVariable final Integer id)
			throws NotIdMismatchEntityException, NotFoundEntityException {
		LOGGER.info("BaseController:update Updating a entry with id: {}", id);

		if (entity.getId() != id) {
			throw new NotIdMismatchEntityException();
		}

		final Optional<T> old = adminService.findById(id);
		if (old == null) {
			throw new NotFoundEntityException();
		}

		final T updated = adminService.save(entity);

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
	public void delete(@PathVariable final Integer id) throws NotFoundEntityException, AppException {
		LOGGER.info("BaseController:delete Deleting a entry with id: {}", id);

		final Optional<T> old = adminService.findById(id);
		if (old == null) {
			throw new NotFoundEntityException();
		}

		try {
			adminService.deleteById(id);
		} catch (Exception e) {
			throw new AppException();
		}
	}

}
