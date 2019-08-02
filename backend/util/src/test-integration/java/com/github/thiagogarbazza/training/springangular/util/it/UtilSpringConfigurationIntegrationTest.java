package com.github.thiagogarbazza.training.springangular.util.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UtilIntegrationTestRunner
class UtilSpringConfigurationIntegrationTest {

  @Value("${app.util.integratio-test}")
  private String property;

  @Test
  void verificarFezLeituraDoArquivoDeConfiguracao() {
    assertEquals("Integration test for module util.", property);
  }
}
