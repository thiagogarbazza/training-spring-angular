package com.github.thiagogarbazza.training.springangular.rest.it;

import com.github.thiagogarbazza.training.springangular.adapter.mail.EmailAdapter;
import com.github.thiagogarbazza.training.springangular.adapter.mail.EmailAdapterStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestIntegrationTestRunner
class RestSpringConfigurationIntegrationTest {

  @Autowired
  private EmailAdapter emailAdapter;
  @Autowired
  private EmailAdapterStub emailAdapterStub;
  @Value("${app.rest.integration-test}")
  private String property;

  @Test
  void verificarFezLeituraDoArquivoDeConfiguracao() {
    assertEquals("Integration test for module rest.", property);
  }

  @Test
  void verificarInjectComponenteReal() {
    assertNotNull(emailAdapter);
  }

  @Test
  void verificarInjectComponenteStub() {
    assertNotNull(emailAdapterStub);
  }

  @Test
  void verificarInjectDeveInjetarOStubPoisEstaMarcadoComoPrimary() {
    assertEquals(emailAdapter, emailAdapterStub);
  }
}
