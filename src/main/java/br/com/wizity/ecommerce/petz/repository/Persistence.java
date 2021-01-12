/*
--+
    | Project PETZ API SERVICE - Java Class File : 1.0.0 Data: 12/01/2021
    | Copyright(c) by Wizity Tecnologia LTDA
    |
    | All rights reserved.
    |
    | This software is confidential and proprietary information of
    | Wizity Tecnologia LTDA ("Confidential Information").
    | You shall not disclose such Confidential Information and shall 
    | use it only in accordance with the terms of the license agreement
    | you entered with Wizity Tecnologia LTDA.
 +--
 */
package br.com.wizity.ecommerce.petz.repository;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.wizity.ecommerce.petz.util.PetzServiceUtil;

/**
 * @author Gilson de Andrade Silva
 *
 * JPA Persistence configurations.
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "br.com.wizity.ecommerce.petz.entity")
public class Persistence {
	
	/**
	 * Set the logger factory. 
	 */
	static Logger logger = LoggerFactory.getLogger(Persistence.class);	
	
	@Bean
    public ComboPooledDataSource dataSource() {
        
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
 
        try {
        	
            dataSource.setDriverClass(System.getenv().get("DATABASE_DRIVER_CLASS"));
            
        } catch (PropertyVetoException e){
        	
        	logger.error("Cannot load datasource driver (" + System.getenv().get("DATABASE_DRIVER_CLASS") +") : " + e.getMessage());
        	
            return null;
        }
        
        dataSource.setJdbcUrl(System.getenv().get("DATABASE_URL_SERVER"));
        dataSource.setUser(PetzServiceUtil.getDataBaseUsername());
        dataSource.setPassword(PetzServiceUtil.getDataBasePassword());
        dataSource.setMinPoolSize(Integer.parseInt("10"));
        dataSource.setMaxPoolSize(Integer.parseInt("50"));
        dataSource.setMaxIdleTime(Integer.parseInt("300"));
 
        return dataSource;
    }
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource dataSource) {
		 
	    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
	    
	    entityManagerFactory.setDataSource(dataSource);
	    entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	    entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
	    entityManagerFactory.setPackagesToScan("br.com.wizity.ecommerce.petz.entity");
	    
	    Map<String, String> props = new HashMap<String,String>();
		
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.jdbc.lob.non_contextual_creation", "true");
		props.put("hibernate.jdbc.wrap_result_sets", "false");
	    
	    entityManagerFactory.setJpaPropertyMap(props);
	    
	    return entityManagerFactory;
	    
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		
	    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
	    
	    jpaTransactionManager.setEntityManagerFactory(emf);
	    
	    return jpaTransactionManager;
	    
	}

}
