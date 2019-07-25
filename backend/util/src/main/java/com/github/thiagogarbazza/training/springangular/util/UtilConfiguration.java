package com.github.thiagogarbazza.training.springangular.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({UtilConfiguration.PACOTE})
@PropertySource("classpath:application-util.properties")
public class UtilConfiguration {

  static final String PACOTE = "com.github.thiagogarbazza.training.springangular.util";
}
