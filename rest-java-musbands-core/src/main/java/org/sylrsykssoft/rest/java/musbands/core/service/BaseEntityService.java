package org.sylrsykssoft.rest.java.musbands.core.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseEntity;
import org.sylrsykssoft.rest.java.musbands.core.repository.BaseEntityRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * BaseService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T>
 *            Type class.
 */
@Transactional()
@Slf4j()
public class BaseEntityService<T extends BaseEntity> implements BaseService<T, Long> {

	@Autowired()
	private BaseEntityRepository<T> repository;

	@Override()
	public <S extends T> S save(S entity) {
		LOGGER.info("BaseService:save Save entity {}.", entity);
		return repository.save(entity);
	}

	@Override()
	public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
		LOGGER.info("BaseService:saveAll Save entities {}.", entities);
		return repository.saveAll(entities);
	}

	@Override()
	public Optional<T> findById(Long id) {
		LOGGER.info("BaseService:findById Find one by id {}.", id);
		return repository.findById(id);
	}

	@Override()
	public boolean existsById(Long id) {
		LOGGER.info("BaseService:existsById Exists entity by id {}.", id);
		return repository.existsById(id);
	}

	@Override
	public Iterable<T> findAll() {
		LOGGER.info("BaseService:findAll Find all.");
		return repository.findAll();
	}

	@Override()
	public Iterable<T> findAllById(Iterable<Long> ids) {
		LOGGER.info("BaseService:findAllById Find all by ids {}.", ids);
		return repository.findAllById(ids);
	}

	@Override()
	public long count() {
		LOGGER.info("BaseService:count Count.");
		return repository.count();
	}

	@Override()
	public void deleteById(Long id) {
		LOGGER.info("BaseService:deleteById Delete entity by id {}.", id);
		repository.deleteById(id);
	}

	@Override()
	public void delete(T entity) {
		LOGGER.info("BaseService:delete Delete by entity {}.", entity);
		repository.delete(entity);
	}

	@Override()
	public void deleteAll(Iterable<? extends T> entities) {
		LOGGER.info("BaseService:delete Delete entities by list {}.", entities);
		repository.deleteAll(entities);
	}

	@Override()
	public void deleteAll() {
		LOGGER.info("BaseService:deleteAll Delete all entities.");
		repository.deleteAll();
	}
}
