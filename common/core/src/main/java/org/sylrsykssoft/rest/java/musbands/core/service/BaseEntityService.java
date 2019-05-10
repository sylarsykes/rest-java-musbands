package org.sylrsykssoft.rest.java.musbands.core.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseEntityResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseEntity;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotFoundEntityException;
import org.sylrsykssoft.rest.java.musbands.core.mapper.IMapperFunction;
import org.sylrsykssoft.rest.java.musbands.core.repository.BaseEntityRepository;

/**
 * BaseService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Logging(Logging.DEBUG)
public abstract class BaseEntityService<T extends BaseEntity, R extends BaseEntityResource> implements IEntityService<T, R, Long>, IMapperFunction<T, R> {

	@Autowired()
	private BaseEntityRepository<T> repository;

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public Optional<R> findById(Long id) throws NotFoundEntityException {
		final Optional<T> source = repository.findById(id);
		return Optional.of(source.flatMap(
				(input) -> (input == null) ? Optional.empty() : Optional.of(getMapperEntityToResource().apply(input))).orElseThrow(NotFoundEntityException::new));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public R getOne(Long id) throws NotFoundEntityException {
		final T source = repository.getOne(id);
		return getMapperEntityToResource().apply(source);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<R> findAll() {
		final List<T> sources = repository.findAll();
		return sources.stream().map(getMapperEntityToResource()::apply).collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public List<R> findAllById(Iterable<Long> ids) {
		final List<T> sources = repository.findAllById(ids);
		return sources.stream().map(getMapperEntityToResource()::apply).collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public long count() {
		return repository.count();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public R save(final R entity) throws NotFoundEntityException {
		if (entity.getID() != null && !existsById(entity.getID())) {
			throw new NotFoundEntityException();
		}

		final T source = repository.save(getMapperResourceToEntity().apply(entity));
		return getMapperEntityToResource().apply(source);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public List<R> saveAll(final Iterable<R> sources) throws NotFoundEntityException {
		final Iterable<T> entities = StreamSupport.stream(sources.spliterator(), false)
				.map(getMapperResourceToEntity()::apply).collect(Collectors.toList());

		return StreamSupport.stream(entities.spliterator(), false).map(getMapperEntityToResource()::apply)
				.collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void deleteById(Long id) throws NotFoundEntityException {
		repository.deleteById(id);
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
		repository.delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void deleteAll(Iterable<? extends R> sources) throws NotFoundEntityException {
		final Iterable<T> entities = StreamSupport.stream(sources.spliterator(), false)
				.map(getMapperResourceToEntity()::apply).collect(Collectors.toList());

		repository.deleteAll(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override()
	public void deleteAll() {
		repository.deleteAll();
	}
}
