package com.github.thiagogarbazza.training.springangular.rest.it;

import com.github.thiagogarbazza.training.springangular.rest.controler.ApplicationInfoRestController;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestIntegrationTestRunner
class RestSpringControllerIntegrationTest {

  @Inject
  private ApplicationInfoRestController applicationInfoRestController;

  @Test
  void verificarInjenctController() {
    assertNotNull(applicationInfoRestController);
  }
}
