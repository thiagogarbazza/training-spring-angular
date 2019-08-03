package com.github.thiagogarbazza.training.springangular.util.it;

import com.github.thiagogarbazza.training.springangular.util.calendario.CalendarioAdapter;
import com.github.thiagogarbazza.training.springangular.util.calendario.CalendarioAdapterStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@UtilIntegrationTestRunner
class UtilSpringConfigurationIntegrationTest {

  @Autowired
  private CalendarioAdapter calendarioAdapter;
  @Autowired
  private CalendarioAdapterStub calendarioAdapterStub;
  @Value("${app.util.integratio-test}")
  private String property;

  @Test
  void verificarFezLeituraDoArquivoDeConfiguracao() {
    assertEquals("Integration test for module util.", property);
  }

  @Test
  void verificarInjectComponenteReal() {
    assertNotNull(calendarioAdapter);
  }

  @Test
  void verificarInjectComponenteStub() {
    assertNotNull(calendarioAdapterStub);
  }

  @Test
  void verificarInjectDeveInjetarOStubPoisEstaMarcadoComoPrimary() {
    assertEquals(calendarioAdapter, calendarioAdapterStub);
  }
}
