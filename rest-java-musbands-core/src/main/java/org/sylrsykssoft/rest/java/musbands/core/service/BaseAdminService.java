package org.sylrsykssoft.rest.java.musbands.core.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseAdminResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotFoundEntityException;
import org.sylrsykssoft.rest.java.musbands.core.repository.BaseAdminRepository;
import org.sylrsykssoft.rest.java.musbands.core.util.BaseAdminModelMapperEntityToResourceFunction;
import org.sylrsykssoft.rest.java.musbands.core.util.BaseAdminModelMapperResourceToEntityFunction;

import lombok.extern.slf4j.Slf4j;

/**
 * BaseAdminService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Slf4j()
public class BaseAdminService<T extends BaseAdmin, R extends BaseAdminResource> implements AdminService<T, R, Integer> {

	@Autowired()
	protected BaseAdminRepository<T> superAdminRepository;

	@Autowired()
	protected BaseAdminModelMapperEntityToResourceFunction<T, R> baseAdminModelMapperEntityToResourceFunction;
	
	@Autowired()
	protected BaseAdminModelMapperResourceToEntityFunction<R, T> baseAdminModelMapperResourceToEntityFunction;

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public Optional<R> findByName(final String name) throws NotFoundEntityException {
		LOGGER.info("BaseAdminService:findByName Find by name {}.", name);

		final Optional<T> source = superAdminRepository.findByName(name);

		LOGGER.info("Exit -> {} ", source);
		return Optional.of(baseAdminModelMapperEntityToResourceFunction.apply(source.get()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public Optional<R> findById(Integer id) throws NotFoundEntityException {
		LOGGER.info("BaseAdminService:findOne Find one by id {}.", id);

		final Optional<T> source = superAdminRepository.findById(id);

		LOGGER.info("Exit -> {} ", source);
		return Optional.of(baseAdminModelMapperEntityToResourceFunction.apply(source.get()));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public R getOne(Integer id) throws NotFoundEntityException {
		LOGGER.info("BaseAdminService:findOne Find one by id {}.", id);
		
		final T source = superAdminRepository.getOne(id);
		
		return baseAdminModelMapperEntityToResourceFunction.apply(source);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<R> findAll() {
		LOGGER.info("BaseAdminService:findAll Find all.");

		List<T> sources = superAdminRepository.findAll();

		LOGGER.info("Exit -> {} ", sources);

		return sources.stream().map(baseAdminModelMapperEntityToResourceFunction::apply).collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public List<R> findAllById(Iterable<Integer> ids) {
		LOGGER.info("BaseAdminService:findAll Find all by ids {}.", ids);

		List<T> sources = superAdminRepository.findAllById(ids);

		LOGGER.info("Exit -> {} ", sources);
		return sources.stream().map(baseAdminModelMapperEntityToResourceFunction::apply).collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public long count() {
		LOGGER.info("BaseAdminService:count Count.");
		
		long c = superAdminRepository.count();
		
		LOGGER.info("Exit -> {} ", c);
		return c;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public boolean existsById(Integer id) {
		LOGGER.info("BaseAdminService:exists Exists entity by id {}.", id);
		
		return superAdminRepository.existsById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public R save(final R entity) throws NotFoundEntityException {
		LOGGER.info("BaseAdminService:save Save entity {}.", entity);
		
		if (entity.getID() != null && !existsById(entity.getID())) {
			throw new NotFoundEntityException();
		}
		
		T source = superAdminRepository.save(baseAdminModelMapperResourceToEntityFunction.apply(entity));
		
		LOGGER.info("Exit -> {} ", source);
		return baseAdminModelMapperEntityToResourceFunction.apply(source);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public List<R> saveAll(final Iterable<R> sources) throws NotFoundEntityException {
		LOGGER.info("BaseAdminService:saveAll Save entities {}.", sources);
		
		Iterable<T> entities = StreamSupport.stream(sources.spliterator(), false)
				.map(baseAdminModelMapperResourceToEntityFunction::apply)
				.collect(Collectors.toList());
		
		LOGGER.info("Exit -> {} ", entities);
		
		return StreamSupport.stream(entities.spliterator(), false)
				.map(baseAdminModelMapperEntityToResourceFunction::apply)
				.collect(Collectors.toList());
	}

	@Override()
	public void deleteById(Integer id) throws NotFoundEntityException {
		LOGGER.info("BaseAdminService:delete Delete entity by id {}.", id);
		superAdminRepository.deleteById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void delete(R source) throws NotFoundEntityException {
		LOGGER.info("BaseAdminService:delete Delete by entity {}.", source);
		
		if (source.getID() != null && !existsById(source.getID())) {
			throw new NotFoundEntityException();
		}
		
		T entity = baseAdminModelMapperResourceToEntityFunction.apply(source);
		superAdminRepository.delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void deleteAll(Iterable<? extends R> sources) throws NotFoundEntityException {
		LOGGER.info("BaseAdminService:delete Delete entities by list {}.", sources);
		
		Iterable<T> entities = StreamSupport.stream(sources.spliterator(), false)
				.map(baseAdminModelMapperResourceToEntityFunction::apply)
				.collect(Collectors.toList());
		
		superAdminRepository.deleteAll(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void deleteAll() {
		LOGGER.info("BaseAdminService:deleteAll Delete all entities.");
		superAdminRepository.deleteAll();
	}

}
