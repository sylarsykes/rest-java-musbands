package org.sylrsykssoft.rest.java.musbands.musicalGenre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.sylrsykssoft.rest.java.musbands.core.mapper.BaseAdminModelMapperEntityToResourceFunction;
import org.sylrsykssoft.rest.java.musbands.core.mapper.BaseAdminModelMapperResourceToEntityFunction;
import org.sylrsykssoft.rest.java.musbands.core.service.BaseAdminService;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.controller.resource.MusicalGenreResource;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.mapper.MusicalGenreModelMapperEntityToResourceFunction;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.mapper.MusicalGenreModelMapperResourceToEntityFunction;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.repository.MusicalGenreRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * MusicalGenreService service.
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <T> Type class.
 */
@Service()
@CacheConfig(cacheNames = {"musicalGenres"}, cacheManager = "musicalGenreCacheManager", keyGenerator = "customKeyGenerator")
@Slf4j()
public class MusicalGenreService extends BaseAdminService<MusicalGenre, MusicalGenreResource> {

	@Autowired()
	private MusicalGenreRepository adminRepository;
	
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
	@Cacheable("musicalGenres")
	public Optional<MusicalGenreResource> findByName(final String name) {
		LOGGER.info("MusicalGenreService:findByName Find by name {}.", name);
		return super.findByName(name);
	}


	/**
	 * Find all musical genres
	 * 
	 * Refresh all the entries in the cache to load new ones
	 */
	@Override
	@Cacheable("musicalGenres")
	public List<MusicalGenreResource> findAll() {
		LOGGER.info("MusicalGenreService:findAll Find all.");
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