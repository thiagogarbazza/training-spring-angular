package com.github.thiagogarbazza.training.springangular.rest.it.controller;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoConsultaService;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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

  @Autowired
  private WebApplicationContext context;

  //  @Captor
  //  private ArgumentCaptor<GrupoDocumentoFiltroConsulta> captor;

  private MockMvc mockMvc;
  @MockBean
  private GrupoDocumentoConsultaService grupoDocumentoConsultaService;

  @BeforeEach
  final void setupWebTest() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    //    Mockito.when(grupoDocumentoConsultaService.pesquisar(captor.capture())).thenReturn(EMPTY_LIST);
  }

  @Test
  void verificandoRetorno() throws Exception {
    this.mockMvc
      .perform(get("/application-info"))
      //      .andDo(result -> {
      //        final GrupoDocumentoFiltroConsulta value = captor.getValue();
      //      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.ambiente", equalTo(DESCONHECIDO.name())))
      .andExpect(jsonPath("$.versao", equalTo(buildInfoVersion)))
      .andExpect(jsonPath("$.versaoDataHora", equalTo(buildInfoTimestamp)))
      .andExpect(jsonPath("$.acoes.podeVerChangeLog", equalTo(true)));
  }
}
