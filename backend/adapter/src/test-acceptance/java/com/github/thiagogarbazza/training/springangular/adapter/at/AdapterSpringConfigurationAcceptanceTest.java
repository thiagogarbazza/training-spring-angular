package com.github.thiagogarbazza.training.springangular.adapter.at;

import com.github.thiagogarbazza.training.springangular.adapter.calendario.CalendarioAdapter;
import com.github.thiagogarbazza.training.springangular.adapter.calendario.CalendarioAdapterStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AdapterAcceptanceTestRunner
class AdapterSpringConfigurationAcceptanceTest {

  @Autowired
  private CalendarioAdapter calendarioAdapter;
  @Autowired
  private CalendarioAdapterStub calendarioAdapterStub;
  @Value("${app.adapter.acceptance-test}")
  private String property;

  @Test
  void verificarFezLeituraDoArquivoDeConfiguracao() {
    assertEquals("Acceptance test for module adapter.", property);
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
