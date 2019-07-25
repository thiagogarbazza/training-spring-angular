package com.github.thiagogarbazza.training.springangular.core;

import com.github.thiagogarbazza.training.springangular.util.UtilConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({UtilConfiguration.class})
@ComponentScan({CoreConfiguration.PACOTE})
@PropertySource("classpath:application-core.properties")
public class CoreConfiguration {

  public static final String PACOTE = " com.github.thiagogarbazza.training.springangular.core";
}
