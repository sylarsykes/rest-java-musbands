package org.sylrsykssoft.rest.java.musbands.core.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.NoRepositoryBean;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseEntity;

@NoRepositoryBean()
@Transactional()
public interface BaseEntityRepository<T extends BaseEntity> extends BaseRepository<T, Long> {

}
