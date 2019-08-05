package com.github.thiagogarbazza.training.springangular.geraresperado.it;

import com.github.thiagogarbazza.training.springangular.util.calendario.CalendarioAdapter;
import com.github.thiagogarbazza.training.springangular.util.calendario.CalendarioAdapterStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@GerarEsperadoIntegrationTestRunner
class GerarEsperadoSpringConfigurationIntegrationTest {

  @Autowired
  private CalendarioAdapter calendarioAdapter;
  @Autowired
  private CalendarioAdapterStub calendarioAdapterStub;
  @Value("${app.gerar-esperado.integration-test}")
  private String property;

  @Test
  void verificarFezLeituraDoArquivoDeConfiguracao() {
    assertEquals("Integration test for module gerar-esperado.", property);
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
