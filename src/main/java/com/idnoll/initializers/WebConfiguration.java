package com.idnoll.initializers;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.core.env.Environment;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.idnoll")
@PropertySource("classpath:application.properties")
public class WebConfiguration extends WebMvcConfigurerAdapter {
	
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
     
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    private static final String PROPERTY_NAME_HIBERNATE_DDL_AUTO = "spring.jpa.hibernate.ddl-auto";
	
	@Resource
	private Environment enviroment;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true)
		.useJaf(false)
		.ignoreAcceptHeader(true)
		.mediaType("html", MediaType.TEXT_HTML)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.defaultContentType(MediaType.TEXT_HTML);
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(enviroment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(enviroment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(enviroment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(enviroment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
    	
		return dataSource;	
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
		entityManagerFactoryBean.setPackagesToScan(enviroment.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
		
		entityManagerFactoryBean.setJpaProperties(hibernationProperties());
		
		return entityManagerFactoryBean;
	}

	private Properties hibernationProperties(){
		Properties properties = new Properties();
		
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, enviroment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
    	properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, enviroment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
    	properties.put(PROPERTY_NAME_HIBERNATE_DDL_AUTO, enviroment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DDL_AUTO));
    	return properties;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	

	@Bean
	public ViewResolver viewResolver(ContentNegotiationManager manager){
		
		List<ViewResolver> resolvers = new ArrayList<>();
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
	
		resolvers.add(resolver);
		
		ContentNegotiatingViewResolver contentResolver = new ContentNegotiatingViewResolver();
		contentResolver.setViewResolvers(resolvers);
		contentResolver.setContentNegotiationManager(manager);
		
		return contentResolver;
	}

}
