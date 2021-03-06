package com.github.thiagogarbazza.training.springangular.batchcomum;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@EnableBatchProcessing
@ComponentScan(BatchComumConfiguration.PACKAGE)
@PropertySource("classpath:application-batch-comum.properties")
public class BatchComumConfiguration {

  static final String PACKAGE = "com.github.thiagogarbazza.training.springangular.batchcomum";
}
