package org.sylrsykssoft.rest.java.musbands.core.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.sylrsykssoft.rest.java.musbands.core.domain.Base;

@NoRepositoryBean()
@Transactional()
public interface BaseRepository<T extends Base, ID extends Serializable> extends JpaRepository<T, ID> {

}
