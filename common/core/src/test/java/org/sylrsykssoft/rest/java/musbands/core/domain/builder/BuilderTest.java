package org.sylrsykssoft.rest.java.musbands.core.domain.builder;

import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sylrsykssoft.rest.java.musbands.core.RestJavaMusbandsCoreApplication;
import org.sylrsykssoft.rest.java.musbands.core.domain.Base;
import org.sylrsykssoft.rest.java.musbands.core.domain.Base.BaseBuilder;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin;
import org.sylrsykssoft.rest.java.musbands.core.domain.BaseAdmin.BaseAdminBuilder;

/**
 * Builder tests
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { RestJavaMusbandsCoreApplication.class })
public class BuilderTest {

	@Autowired
    ApplicationContext applicationContext;
	
	@Before
	public void setUp() {

	}
	
	@Test
	public void testBaseBuilder() {
		Date createdAt = new Date();
		Date updatedAt = new Date();

		BaseBuilder builder = new BaseBuilder();
		
		Assert.assertNotNull(builder);
		
		Base domain = builder.createdAt(createdAt).updatedAt(updatedAt).build();
		
		Assert.assertNotNull(domain);
	}
	
	@Test
	public void testBaseAdminBuilder() {
		Date createdAt = new Date();
		Date updatedAt = new Date();
		Integer id = NumberUtils.INTEGER_ONE;
		String name = "aaa";
		String description = "aaaabbbbcccaaccvvdd";
		
		System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
		
		BaseAdminBuilder builder = new BaseAdminBuilder();
		
		Assert.assertNotNull(builder);
		
		BaseAdmin domain = builder.id(id).name(name)
				.description(description).build();
		
		Assert.assertNotNull(domain);
	}
}
