package org.sylrsykssoft.rest.java.musbands.musicalGenre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.sylrsykssoft.rest.java.musbands.aspects.logger.annotation.Logging;
import org.sylrsykssoft.rest.java.musbands.core.exception.NotFoundEntityException;
import org.sylrsykssoft.rest.java.musbands.core.mapper.BaseAdminModelMapperEntityToResourceFunction;
import org.sylrsykssoft.rest.java.musbands.core.mapper.BaseAdminModelMapperResourceToEntityFunction;
import org.sylrsykssoft.rest.java.musbands.core.service.BaseAdminService;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.mapper.MusicalGenreModelMapperEntityToResourceFunction;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.mapper.MusicalGenreModelMapperResourceToEntityFunction;

/**
 * MusicalGenreService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Service()
@CacheConfig(cacheNames = {"musicalGenres"}, cacheManager = "musicalGenreCacheManager", keyGenerator = "customKeyGenerator")
@Logging(Logging.DEBUG)
public class MusicalGenreService extends BaseAdminService<MusicalGenre, MusicalGenreResource> {

	@Autowired
	private MusicalGenreModelMapperEntityToResourceFunction baseAdminModelMapperEntityToResourceFunction;
	
	@Autowired
	private MusicalGenreModelMapperResourceToEntityFunction baseAdminModelMapperResourceToEntityFunction;

	/**
	 * Find musical genre by name
	 * 
	 * Refresh all the entries in the cache to load new ones
	 */
	@Override()
	@Cacheable(value = "musicalGenres", condition = "#result.isPresent()", key = "#result.get().id")
	public Optional<MusicalGenreResource> findByName(final String name) throws NotFoundEntityException {
		return super.findByName(name);
	}


	/**
	 * Find all musical genres
	 * 
	 * Refresh all the entries in the cache to load new ones
	 */
	@Override
	@Cacheable(value = "musicalGenres", unless = "#result != null")
	public List<MusicalGenreResource> findAll() {
		return super.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseAdminModelMapperEntityToResourceFunction<MusicalGenre, MusicalGenreResource> getMapperEntityToResource() {
		return baseAdminModelMapperEntityToResourceFunction;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseAdminModelMapperResourceToEntityFunction<MusicalGenreResource, MusicalGenre> getMapperResourceToEntity() {
		return baseAdminModelMapperResourceToEntityFunction;
	}
	
}