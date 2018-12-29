package org.sylrsykssoft.rest.java.musbands.core.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseAdminResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotFoundEntityException;
import org.sylrsykssoft.rest.java.musbands.core.mapper.AdminMapperFunction;
import org.sylrsykssoft.rest.java.musbands.core.repository.BaseAdminRepository;

/**
 * BaseAdminService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Logging(Logging.DEBUG)
public abstract class BaseAdminService<T extends BaseAdmin, R extends BaseAdminResource> implements AdminService<T, R, Integer>, AdminMapperFunction<T, R> {

	@Autowired()
	protected BaseAdminRepository<T> superAdminRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public Optional<R> findByName(final String name) throws NotFoundEntityException {
		final Optional<T> source = superAdminRepository.findByName(name);
		return Optional.of(source.flatMap(
				(input) -> (input == null) ? Optional.empty() : Optional.of(getMapperEntityToResource().apply(input)))
				.orElseThrow(NotFoundEntityException::new));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public Optional<R> findById(Integer id) throws NotFoundEntityException {
		final Optional<T> source = superAdminRepository.findById(id);
		return Optional.of(source.flatMap(
				(input) -> (input == null) ? Optional.empty() : Optional.of(getMapperEntityToResource().apply(input)))
				.orElseThrow(NotFoundEntityException::new));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public R getOne(Integer id) throws NotFoundEntityException {
		final T source = superAdminRepository.getOne(id);
		return getMapperEntityToResource().apply(source);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<R> findAll() {
		final List<T> sources = superAdminRepository.findAll();
		return sources.stream().map(getMapperEntityToResource()::apply).collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public List<R> findAllById(Iterable<Integer> ids) {
		final List<T> sources = superAdminRepository.findAllById(ids);
		return sources.stream().map(getMapperEntityToResource()::apply).collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public long count() {
		return superAdminRepository.count();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public boolean existsById(Integer id) {
		return superAdminRepository.existsById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public R save(final R entity) throws NotFoundEntityException {
		if (entity.getID() != null && !existsById(entity.getID())) {
			throw new NotFoundEntityException();
		}
		
		final T source = superAdminRepository.save(getMapperResourceToEntity().apply(entity));
		return getMapperEntityToResource().apply(source);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public List<R> saveAll(final Iterable<R> sources) throws NotFoundEntityException {
		final Iterable<T> entities = StreamSupport.stream(sources.spliterator(), false)
				.map(getMapperResourceToEntity()::apply)
				.collect(Collectors.toList());
		
		return StreamSupport.stream(entities.spliterator(), false)
				.map(getMapperEntityToResource()::apply)
				.collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void deleteById(Integer id) throws NotFoundEntityException {
		superAdminRepository.deleteById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void delete(R source) throws NotFoundEntityException {
		if (source.getID() != null && !existsById(source.getID())) {
			throw new NotFoundEntityException();
		}
		
		final T entity = getMapperResourceToEntity().apply(source);
		superAdminRepository.delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void deleteAll(Iterable<? extends R> sources) throws NotFoundEntityException {
		final Iterable<T> entities = StreamSupport.stream(sources.spliterator(), false)
				.map(getMapperResourceToEntity()::apply)
				.collect(Collectors.toList());
		
		superAdminRepository.deleteAll(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void deleteAll() {
		superAdminRepository.deleteAll();
	}

}
