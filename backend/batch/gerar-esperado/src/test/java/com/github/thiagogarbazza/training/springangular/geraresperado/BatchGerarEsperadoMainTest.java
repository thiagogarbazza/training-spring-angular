package com.github.thiagogarbazza.training.springangular.geraresperado;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
@EnableBatchProcessing
//@EnableAutoConfiguration
@PropertySource("classpath:application-batch-gerar-esperado-execucao-local.properties")
@ComponentScan("com.github.thiagogarbazza.training.springangular")
//@EntityScan("com.github.thiagogarbazza.training.springangular")
@EnableJpaRepositories("com.github.thiagogarbazza.training.springangular")
  //@Import({AdapterIntegrationTestConfiguration.class, BatchGerarEsperadoConfiguration.class})
class BatchGerarEsperadoMainTest {

  public static void main(String[] args) {
    //final ConfigurableApplicationContext context = new SpringApplicationBuilder()      .sources(BatchGerarEsperadoMainTest.class)      .run(args);
  }
}
