package com.github.thiagogarbazza.training.springangular.utiltest.database;

import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.envers.configuration.EnversSettings;
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
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

    driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
    driverManagerDataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
    driverManagerDataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
    driverManagerDataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));

    return driverManagerDataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    log.trace("Configurando entity manager factory.");
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

    localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    localContainerEntityManagerFactoryBean.setDataSource(dataSource);

    localContainerEntityManagerFactoryBean.setJpaProperties(aditionalProperties());
    localContainerEntityManagerFactoryBean.setPackagesToScan("com.github.thiagogarbazza.training.springangular");

    return localContainerEntityManagerFactoryBean;
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
    properties.setProperty(EnversSettings.AUDIT_TABLE_PREFIX, "aud_");
    properties.setProperty(EnversSettings.AUDIT_TABLE_SUFFIX, "");
    properties.setProperty(EnversSettings.REVISION_FIELD_NAME, "revision_id");
    properties.setProperty(EnversSettings.REVISION_TYPE_FIELD_NAME, "revision_type");

    properties.setProperty("javax.persistence.schema-generation.scripts.create-target", "target/data-base/create.sql");
    properties.setProperty("javax.persistence.schema-generation.scripts.drop-target", "target/data-base/drop.sql");



    return properties;
  }
}
