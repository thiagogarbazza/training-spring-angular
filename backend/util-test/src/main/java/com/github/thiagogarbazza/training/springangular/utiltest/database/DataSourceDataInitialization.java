package com.github.thiagogarbazza.training.springangular.utiltest.database;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.config.SortedResourcesFactoryBean;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import javax.sql.DataSource;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@CommonsLog
class DataSourceDataInitialization implements InitializingBean {

  @Autowired
  private DataSource dataSource;
  @javax.annotation.Resource
  private Environment environment;
  @Autowired
  private ResourceLoader resourceLoader;

  @Override
  public void afterPropertiesSet() throws Exception {
    final String data = environment.getProperty("spring.datasource.data");
    if (isBlank(data)) {
      return;
    }

    log.trace(format("Serão utilizados os arquivos {0} para inicializar o banco de dados.", data));

    final String[] files = StringUtils.split(data, ",");

    SortedResourcesFactoryBean factory = new SortedResourcesFactoryBean(this.resourceLoader, Arrays.asList(files));
    factory.afterPropertiesSet();
    final Resource[] resources = factory.getObject();

    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.setContinueOnError(false);
    populator.setSeparator(";");

    for (Resource resource : resources) {
      populator.addScript(resource);
    }

    DatabasePopulatorUtils.execute(populator, dataSource);

    log.trace(format("Banco de dados inicializado com sucesso!", data));
  }
}
