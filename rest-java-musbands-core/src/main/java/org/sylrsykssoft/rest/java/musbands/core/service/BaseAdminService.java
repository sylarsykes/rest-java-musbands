package org.sylrsykssoft.rest.java.musbands.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;
import org.sylrsykssoft.rest.java.musbands.core.repository.BaseAdminRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * BaseAdminService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Slf4j()
public class BaseAdminService<T extends BaseAdmin> implements AdminService<T, Integer> {

	@Autowired()
	private BaseAdminRepository<T> adminRepository;
	
	@Override()
	public Optional<T> findByName(String name) {
		LOGGER.info("BaseAdminService:findByName Find by name {}.", name);
		return adminRepository.findByName(name);
	}
	
	@Override()
	public <S extends T> S save(S entity) {
		LOGGER.info("BaseAdminService:save Save entity {}.", entity);
		return adminRepository.save(entity);
	}

	@Override()
	public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
		LOGGER.info("BaseAdminService:saveAll Save entities {}.", entities);
		return adminRepository.saveAll(entities);
	}

	@Override()
	public Optional<T> findById(Integer id) {
		LOGGER.info("BaseAdminService:findOne Find one by id {}.", id);
		return adminRepository.findById(id);
	}

	@Override()
	public boolean existsById(Integer id) {
		LOGGER.info("BaseAdminService:exists Exists entity by id {}.", id);
		return adminRepository.existsById(id);
	}

	@Override
	public Iterable<T> findAll() {
		LOGGER.info("BaseAdminService:findAll Find all.");
		return adminRepository.findAll();
	}

	@Override()
	public Iterable<T> findAllById(Iterable<Integer> ids) {
		LOGGER.info("BaseAdminService:findAll Find all by ids {}.", ids);
		return adminRepository.findAllById(ids);
	}

	@Override()
	public long count() {
		LOGGER.info("BaseAdminService:count Count.");
		return adminRepository.count();
	}

	@Override()
	public void deleteById(Integer id) {
		LOGGER.info("BaseAdminService:delete Delete entity by id {}.", id);
		adminRepository.deleteById(id);
	}

	@Override()
	public void delete(T entity) {
		LOGGER.info("BaseAdminService:delete Delete by entity {}.", entity);
		adminRepository.delete(entity);
	}

	@Override()
	public void deleteAll(Iterable<? extends T> entities) {
		LOGGER.info("BaseAdminService:delete Delete entities by list {}.", entities);
		adminRepository.deleteAll(entities);
	}

	@Override()
	public void deleteAll() {
		LOGGER.info("BaseAdminService:deleteAll Delete all entities.");
		adminRepository.deleteAll();
	}
}
