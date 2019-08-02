package com.github.thiagogarbazza.training.springangular.geraresperado.configuration;

import com.github.thiagogarbazza.training.springangular.batchcomum.BatchComumConfiguration;
import com.github.thiagogarbazza.training.springangular.core.CoreConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(BatchGerarEsperadoConfiguration.PACKAGE)
@PropertySource("classpath:application-batch-gerar-esperado.properties")
@Import({BatchComumConfiguration.class, CoreConfiguration.class})
public class BatchGerarEsperadoConfiguration {

  static final String PACKAGE = "com.github.thiagogarbazza.training.springangular.geraresperado";

  private static final String JOB_GERAR_ESPERADO = "jobGerarEsperado";
  private static final String STEP_GERAR_ESPERADO = "stepGerarEsperado";

  @Autowired
  private JobBuilderFactory jobFactory;
  @Autowired
  private StepBuilderFactory stepFactory;

  @Bean
  @Qualifier(JOB_GERAR_ESPERADO)
  protected Job jobGerarEsperado(@Qualifier(STEP_GERAR_ESPERADO) Step stepGerarEsperado) {
    return jobFactory.get(JOB_GERAR_ESPERADO)
      .start(stepGerarEsperado)
      .build();
  }

  @Bean
  @Qualifier(STEP_GERAR_ESPERADO)
  protected Step stepGerarEsperado(GerarEsperadoTasklet tasklet) {
    return stepFactory.get(STEP_GERAR_ESPERADO)
      .tasklet(tasklet)
      .build();
  }
}
