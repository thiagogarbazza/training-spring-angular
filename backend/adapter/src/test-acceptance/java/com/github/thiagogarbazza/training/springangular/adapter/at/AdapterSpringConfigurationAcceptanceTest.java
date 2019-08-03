package com.github.thiagogarbazza.training.springangular.adapter.at;

import com.github.thiagogarbazza.training.springangular.adapter.mail.EmailAdapter;
import com.github.thiagogarbazza.training.springangular.adapter.mail.EmailAdapterStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AdapterAcceptanceTestRunner
class AdapterSpringConfigurationAcceptanceTest {

  @Autowired
  private EmailAdapter emailAdapter;
  @Autowired
  private EmailAdapterStub emailAdapterStub;
  @Value("${app.adapter.acceptance-test}")
  private String property;

  @Test
  void verificarFezLeituraDoArquivoDeConfiguracao() {
    assertEquals("Acceptance test for module adapter.", property);
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
