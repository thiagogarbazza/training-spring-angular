package com.github.thiagogarbazza.training.springangular.geraresperado.configuration;

import com.github.thiagogarbazza.training.springangular.batchcomum.BatchComumConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(BatchGerarEsperadoConfiguration.PACKAGE)
@PropertySource("classpath:application-batch-gerar-esperado.properties")
@Import({BatchComumConfiguration.class})
public class BatchGerarEsperadoConfiguration {

  static final String PACKAGE = "com.github.thiagogarbazza.training.springangular.geraresperado";
}
