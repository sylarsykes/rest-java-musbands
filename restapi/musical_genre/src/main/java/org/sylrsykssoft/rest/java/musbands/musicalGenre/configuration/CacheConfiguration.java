package org.sylrsykssoft.rest.java.musbands.musicalGenre.configuration;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

	@Bean("musicalGenreCacheManager")
	public CacheManager cacheManager() {
		final SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("musicalGenres")));
		return cacheManager;
	}
}
