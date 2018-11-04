package org.sylrsykssoft.rest.java.musbands.musicalGenre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yuequan.jpa.soft.delete.repository.EnableJpaSoftDeleteRepositories;
import org.yuequan.jpa.soft.delete.repository.support.JpaSoftDeleteRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaSoftDeleteRepositories(repositoryFactoryBeanClass = JpaSoftDeleteRepositoryFactoryBean.class)
public class RestJavaMusbandsMusicalGenreApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestJavaMusbandsMusicalGenreApplication.class, args);
	}
}
