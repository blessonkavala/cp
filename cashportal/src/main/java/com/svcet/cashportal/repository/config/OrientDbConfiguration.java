package com.svcet.cashportal.repository.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.OrientObjectTemplate;
import org.springframework.data.orient.object.repository.support.OrientObjectRepositoryFactoryBean;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableOrientRepositories(basePackages = "com.svcet.cashportal.repository", repositoryFactoryBeanClass = OrientObjectRepositoryFactoryBean.class)
public class OrientDbConfiguration {

	@PostConstruct
	@Transactional
	public void registerEntities() {
		factory().db().getEntityManager().registerEntityClasses("com.svcet.cashportal.domain");
	}

	@Bean
	public OrientObjectDatabaseFactory factory() {
		OrientObjectDatabaseFactory factory = new OrientObjectDatabaseFactory();

		// factory.setUrl("plocal:target/spring-data-orientdb-db");
		factory.setUrl("remote:localhost/cp");
		factory.setUsername("admin");
		factory.setPassword("admin");

		return factory;
	}

	@Bean
	public OrientObjectTemplate objectTemplate() {
		return new OrientObjectTemplate(factory());
	}

	@Bean
	public OrientTransactionManager transactionManager() {
		return new OrientTransactionManager(factory());
	}

}
