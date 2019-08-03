package com.github.thiagogarbazza.training.springangular.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
//@EnableAutoConfiguration
@PropertySource("classpath:application-rest-local.properties")
@ComponentScan("com.github.thiagogarbazza.training.springangular")
//@EntityScan("com.github.thiagogarbazza.training.springangular")
@EnableJpaRepositories("com.github.thiagogarbazza.training.springangular")
@Import({RestConfiguration.class})
public class RestExecucaoLocal {

  public static void main(String[] args) {
    //  final ConfigurableApplicationContext context = new SpringApplicationBuilder()
    //  .sources(RestExecucaoLocal.class)
    //.run(args);
  }
}
