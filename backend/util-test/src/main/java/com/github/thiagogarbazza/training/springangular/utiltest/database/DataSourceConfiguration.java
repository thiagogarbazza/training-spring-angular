package com.github.thiagogarbazza.training.springangular.utiltest.database;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@CommonsLog
@Configuration
class DataSourceConfiguration {

  @Resource
  private Environment environment;

  @Bean
  public DataSource dataSource() {
    log.trace("Configurando data source.");
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
    dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
    dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
    dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));

    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    log.trace("Configurando entity manager factory.");
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
    log.trace("Configurando transaction manager.");
    return new JpaTransactionManager(entityManagerFactory);
  }

  private Properties aditionalProperties() {

    Properties properties = new Properties();

    properties.setProperty("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
    properties.setProperty("hibernate.show_sql", environment.getProperty("spring.jpa.properties.hibernate.show_sql"));
    properties.setProperty("hibernate.format_sql", environment.getProperty("spring.jpa.properties.hibernate.format_sql"));
    properties.setProperty("hibernate.use_sql_comments", environment.getProperty("spring.jpa.properties.hibernate.use_sql_comments"));
    properties.setProperty("hibernate.default_schema", environment.getProperty("spring.jpa.properties.hibernate.default_schema"));
    properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.properties.hibernate.hbm2ddl.auto"));

    return properties;
  }
}
