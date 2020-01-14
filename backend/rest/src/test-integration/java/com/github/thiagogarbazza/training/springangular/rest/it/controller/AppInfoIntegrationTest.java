package com.github.thiagogarbazza.training.springangular.rest.it.controller;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class AppInfoIntegrationTest {

  @Value("${app.build-info.timestamp}")
  private String buildInfoTimestamp;
  @Value("${app.build-info.version}")
  private String buildInfoVersion;

  @Autowired
  private WebApplicationContext context;
  @MockBean
  private GrupoDocumentoSearchService grupoDocumentoConsultaService;
  private MockMvc mockMvc;

  @BeforeEach
  final void setupWebTest() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void verificandoRetorno() throws Exception {
    this.mockMvc
      .perform(get("/application-info"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.ambiente", notNullValue()))
      .andExpect(jsonPath("$.ambiente.id", nullValue()))
      .andExpect(jsonPath("$.ambiente.description", equalTo("Desconhecido")))
      .andExpect(jsonPath("$.versao", equalTo(buildInfoVersion)))
      .andExpect(jsonPath("$.versaoDataHora", equalTo(buildInfoTimestamp)))
      .andExpect(jsonPath("$.acoes.podeVerChangeLog", equalTo(true)));
  }
}
