package com.github.thiagogarbazza.training.springangular.core.at;

import com.github.thiagogarbazza.training.springangular.util.calendario.CalendarioAdapter;
import com.github.thiagogarbazza.training.springangular.util.calendario.CalendarioAdapterStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@CoreAcceptanceTestRunner
class CoreSpringConfigurationAcceptanceTest {

  @Autowired
  private CalendarioAdapter calendarioAdapter;
  @Autowired
  private CalendarioAdapterStub calendarioAdapterStub;
  @Value("${app.core.acceptance-test}")
  private String property;

  @Test
  void verificarFezLeituraDoArquivoDeConfiguracao() {
    assertEquals("Acceptance test for module core.", property);
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
