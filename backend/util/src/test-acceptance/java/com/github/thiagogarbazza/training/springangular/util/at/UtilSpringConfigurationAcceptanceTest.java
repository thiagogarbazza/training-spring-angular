package com.github.thiagogarbazza.training.springangular.util.at;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UtilAcceptanceTestRunner
class UtilSpringConfigurationAcceptanceTest {

  @Value("${app.util.acceptance-test}")
  private String property;

  @Test
  void verificarFezLeituraDoArquivoDeConfiguracao() {
    assertEquals("Acceptance test for module util.", property);
  }
}
