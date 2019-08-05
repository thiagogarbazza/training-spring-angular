package com.github.thiagogarbazza.training.springangular.utiltest.database.h2.configuration;

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

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUsername("disney");
    dataSource.setPassword("mickey");
    dataSource.setUrl(
      "jdbc:h2:mem:app-data-base;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false;INIT=RUNSCRIPT FROM 'classpath:application-data-base-schema.sql'");
    dataSource.setDriverClassName("org.h2.Driver");
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
  public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
    return new JpaTransactionManager(emf);
  }

  private Properties aditionalProperties() {
    Properties jpaProperties = new Properties();
    jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    jpaProperties.setProperty("hibernate.show_sql", "false");
    jpaProperties.setProperty("hibernate.format_sql", "false");
    jpaProperties.setProperty("hibernate.ddl-auto", "create");
    jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");

    return jpaProperties;
  }
}
