package com.github.thiagogarbazza.training.springangular.adapter.it;

import com.github.thiagogarbazza.training.springangular.adapter.mail.EmailAdapter;
import com.github.thiagogarbazza.training.springangular.adapter.mail.EmailAdapterStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AdapterIntegrationTestRunner
class AdapterSpringConfigurationIntegrationTest {

  @Autowired
  private EmailAdapter emailAdapter;
  @Autowired
  private EmailAdapterStub emailAdapterStub;
  @Value("${app.adapter.integratio-test}")
  private String property;

  @Test
  void verificarFezLeituraDoArquivoDeConfiguracao() {
    assertEquals("Integration test for module adapter.", property);
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
