package com.github.thiagogarbazza.training.springangular.rest.it.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoDetailService;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.util.validation.ViolationExceptionD4T;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4DetailD4T.grupoDocumentoVO4DetailQualquer;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class GrupoDocumentoDetailIntegrationTest {

  @Captor
  private ArgumentCaptor<UUID> captor;
  @Autowired
  private WebApplicationContext context;
  @MockBean
  private GrupoDocumentoDetailService grupoDocumentoDetailService;
  private MockMvc mockMvc;

  @BeforeEach
  final void setupWebTest() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void verifyDetailError() throws Exception {
    when(grupoDocumentoDetailService.detail(captor.capture())).thenThrow(ViolationExceptionD4T.violationExceptionQualquer());

    this.mockMvc
      .perform(get("/grupo-documento/df160f6e-e4e5-4fbf-a39f-d92acff9eade"))
      .andDo(result -> {
        final UUID value = captor.getValue();
        assertEquals("df160f6e-e4e5-4fbf-a39f-d92acff9eade", value.toString());
      })
      .andExpect(status().isPreconditionFailed())
      .andExpect(jsonPath("$.message", equalTo("There was some violation.")))
      .andExpect(jsonPath("$.violations", hasSize(1)))
      .andExpect(jsonPath("$.violations[0].type", equalTo("ERROR")))
      .andExpect(jsonPath("$.violations[0].key", equalTo("error-key")))
      .andExpect(jsonPath("$.violations[0].content", equalTo("error-content")));
  }

  @Test
  @Disabled("Desabilitado até corrigir a conversão de java.time e dos Enuns")
  void verifyDetailSuccess() throws Exception {
    when(grupoDocumentoDetailService.detail(captor.capture())).thenReturn(grupoDocumentoVO4DetailQualquer());

    this.mockMvc
      .perform(get("/grupo-documento/df160f6e-e4e5-4fbf-a39f-d92acff9eade"))
      .andDo(result -> {
        final UUID value = captor.getValue();
        assertEquals("df160f6e-e4e5-4fbf-a39f-d92acff9eade", value.toString());
      })
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id", equalTo("df160f6e-e4e5-4fbf-a39f-d92acff9eade")))
      .andExpect(jsonPath("$.codigo", equalTo("GRP-CODIGO")))
      .andExpect(jsonPath("$.nome", equalTo("GRP-NOME")))
      .andExpect(jsonPath("$.situacao", notNullValue()))
      .andExpect(jsonPath("$.situacao.id", equalTo(1)))
      .andExpect(jsonPath("$.situacao.description", equalTo("Ativo")))
      .andExpect(jsonPath("$.creation", notNullValue()))
      .andExpect(jsonPath("$.creation.userName", equalTo("mouse.mickey")))
      .andExpect(jsonPath("$.creation.dateTime", equalTo("2000-01-31 23:59:59.999")))
      .andExpect(jsonPath("$.modification", nullValue()))
      .andExpect(jsonPath("$.historicoSituacaos", hasSize(1)))
      .andExpect(jsonPath("$.historicoSituacaos[0].id", equalTo("014f2cc3-ca55-4be9-a392-84850ded3338")))
      .andExpect(jsonPath("$.historicoSituacaos[0].motivo", equalTo("mouse.mickey")))
      .andExpect(jsonPath("$.historicoSituacaos[0].situacao", notNullValue()))
      .andExpect(jsonPath("$.historicoSituacaos[0].situacao.id", equalTo(1)))
      .andExpect(jsonPath("$.historicoSituacaos[0].situacao.description", equalTo("Ativo")))
      .andExpect(jsonPath("$.historicoSituacaos[0].creation", notNullValue()))
      .andExpect(jsonPath("$.historicoSituacaos[0].creation.userName", equalTo("mouse.mickey")))
      .andExpect(jsonPath("$.historicoSituacaos[0].creation.dateTime", equalTo("2000-01-31 23:59:59.999")));
  }
}
