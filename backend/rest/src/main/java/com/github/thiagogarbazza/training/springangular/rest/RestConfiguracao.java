package com.github.thiagogarbazza.training.springangular.rest;

import com.github.thiagogarbazza.training.springangular.core.CoreConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({CoreConfiguration.class})
@ComponentScan({RestConfiguracao.PACOTE})
@PropertySource("classpath:application-rest.properties")
public class RestConfiguracao {

  static final String PACOTE = "com.github.thiagogarbazza.training.springangular.rest";
}
