package com.github.thiagogarbazza.training.springangular.utiltest.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class H2JPAConfiguration {

  @Resource
  private Environment environment;

  @Value("#{spring.jpa.properties}")
  private Properties appProperties;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
    dataSource.setUrl(environment.getProperty("spring.datasource.url"));
    dataSource.setUsername(environment.getProperty("spring.datasource.username"));
    dataSource.setPassword(environment.getProperty("spring.datasource.password"));

    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

    factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    factoryBean.setDataSource(dataSource);

    factoryBean.setJpaProperties(aditionalProperties());
    factoryBean.setPackagesToScan("com.github.thiagogarbazza.training.springangular");

    return factoryBean;
  }

  @Bean
  public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  private Properties aditionalProperties() {

    Properties properties = new Properties();

    properties.setProperty("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
    properties.setProperty("hibernate.show_sql", environment.getProperty("spring.jpa.properties.hibernate.show_sql"));
    properties.setProperty("hibernate.format_sql", environment.getProperty("spring.jpa.properties.hibernate.format_sql"));
    properties.setProperty("hibernate.ddl-auto", environment.getProperty("spring.jpa.properties.hibernate.ddl-auto"));
    properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.properties.hibernate.hbm2ddl.auto"));
    properties.setProperty("hibernate.default_schema", environment.getProperty("spring.jpa.properties.hibernate.default_schema"));
    properties.setProperty("hibernate.hbm2ddl.import_files", environment.getProperty("spring.jpa.properties.hibernate.hbm2ddl.import_files"));

    return properties;
  }
}
