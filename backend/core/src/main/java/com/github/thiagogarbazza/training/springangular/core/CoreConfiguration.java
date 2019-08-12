package com.github.thiagogarbazza.training.springangular.core;

import com.github.thiagogarbazza.training.springangular.adapter.AdapterConfiguration;
import com.github.thiagogarbazza.training.springangular.util.UtilConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({CoreConfiguration.PACOTE})
@EnableJpaRepositories({CoreConfiguration.PACOTE})
@Import({UtilConfiguration.class, AdapterConfiguration.class})
@PropertySource("classpath:application-core.properties")
public class CoreConfiguration {

  public static final String PACOTE = "com.github.thiagogarbazza.training.springangular.core";
}
