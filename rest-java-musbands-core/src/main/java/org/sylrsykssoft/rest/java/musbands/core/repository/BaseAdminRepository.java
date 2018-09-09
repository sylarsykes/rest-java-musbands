package org.sylrsykssoft.rest.java.musbands.core.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;

@NoRepositoryBean()
@Transactional()
public interface BaseAdminRepository<T extends BaseAdmin> extends JpaRepository<T, Integer> {
	
	/**
	 * Find by name.
	 * 
	 * @param name Value of the attribute name
	 * 
	 * @return T entity.
	 */
	Optional<T> findByName(final String name);
}
