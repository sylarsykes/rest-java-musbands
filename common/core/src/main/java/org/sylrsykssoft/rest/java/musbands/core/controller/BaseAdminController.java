package org.sylrsykssoft.rest.java.musbands.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.sylrsykssoft.rest.java.musbands.core.controller.resource.BaseAdminResource;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;
import org.sylrsykssoft.rest.java.musbands.core.mapper.BaseAdminModelMapperEntityToResourceFunction;
import org.sylrsykssoft.rest.java.musbands.core.service.BaseAdminService;

import lombok.extern.slf4j.Slf4j;

/**
 * Base admin controller
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 * @param <R> Resource class
 * @param <T> Admin class
 */
@Slf4j()
public class BaseAdminController<R extends BaseAdminResource, T extends BaseAdmin> {

	@Autowired()
	protected BaseAdminService<T, R> adminService;
	
	@Autowired
	protected BaseAdminModelMapperEntityToResourceFunction<T, R> baseAdminModelMapperEntityToResourceFunction;

}
