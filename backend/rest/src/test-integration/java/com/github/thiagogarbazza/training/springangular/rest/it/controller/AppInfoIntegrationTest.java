package com.github.thiagogarbazza.training.springangular.rest.it.controller;

import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

import static com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao.DESCONHECIDO;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class AppInfoIntegrationTest {

  @Value("${app.build-info.timestamp}")
  private String buildInfoTimestamp;
  @Value("${app.build-info.version}")
  private String buildInfoVersion;
  @Inject
  private MockMvc mockMvc;

  @Test
  void verificandoRetorno() throws Exception {
    this.mockMvc
      .perform(get("/application-info"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.ambiente", equalTo(DESCONHECIDO.name())))
      .andExpect(jsonPath("$.versao", equalTo(buildInfoVersion)))
      .andExpect(jsonPath("$.versaoDataHora", equalTo(buildInfoTimestamp)))
      .andExpect(jsonPath("$.acoes.podeVerChangeLog", equalTo(true)));
  }
}
