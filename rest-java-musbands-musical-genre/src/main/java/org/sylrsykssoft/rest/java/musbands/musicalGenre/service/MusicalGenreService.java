package org.sylrsykssoft.rest.java.musbands.musicalGenre.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.sylrsykssoft.rest.java.musbands.core.service.BaseAdminService;
import org.sylrsykssoft.rest.java.musbands.musicalGenre.domain.MusicalGenre;
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
@CacheConfig(cacheNames = {"musicalGenres"})
@Slf4j()
public class MusicalGenreService extends BaseAdminService<MusicalGenre> {

	@Autowired()
	private MusicalGenreRepository adminRepository;

	
	@Override()
	@Cacheable("musicalGenres")
	@CacheEvict(value = "musicalGenres", allEntries = true)
	public Optional<MusicalGenre> findByName(final String name) {
		LOGGER.info("MusicalGenreService:findByName Find by name {}.", name);
		
		final Optional<MusicalGenre> entity = adminRepository.findByName(name);
		
		LOGGER.info("Exit -> {} ", entity);
		return entity;
	}


	/**
	 * Find all musical genres
	 * 
	 * Refresh all the entries in the cache to load new ones
	 */
	@Override
	@Cacheable("musicalGenres")
	@CacheEvict(value = "musicalGenres", allEntries = true)
	public Iterable<MusicalGenre> findAll() {
		LOGGER.info("MusicalGenreService:findAll Find all.");
		
		final Iterable<MusicalGenre> entities = adminRepository.findAll();
		
		LOGGER.info("Exit -> {} ", entities);
		return entities;
	}
	
}