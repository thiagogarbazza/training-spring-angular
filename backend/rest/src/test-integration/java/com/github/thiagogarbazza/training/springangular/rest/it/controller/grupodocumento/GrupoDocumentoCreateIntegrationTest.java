package com.github.thiagogarbazza.training.springangular.rest.it.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoCreateService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Create;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4T.grupoDocumentoQualquerAtivo;
import static com.github.thiagogarbazza.training.springangular.util.validation.ViolationExceptionD4T.violationExceptionQualquer;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class GrupoDocumentoCreateIntegrationTest {

  @Captor
  private ArgumentCaptor<GrupoDocumentoVO4Create> captor;
  @Autowired
  private WebApplicationContext context;
  @MockBean
  private GrupoDocumentoCreateService grupoDocumentoCreateService;
  private MockMvc mockMvc;

  @BeforeEach
  final void setupWebTest() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void verifyCreateError() throws Exception {
    final String content = "{\"codigo\":null,\"nome\":\"GRP-NOME\"}";
    when(grupoDocumentoCreateService.create(captor.capture())).thenThrow(violationExceptionQualquer());

    this.mockMvc
      .perform(post("/grupo-documento").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> {
        final GrupoDocumentoVO4Create value = captor.getValue();
        assertNull(value.getCodigo());
        assertEquals("GRP-NOME", value.getNome());
      })
      .andExpect(status().isPreconditionFailed())
      .andExpect(jsonPath("$.message", equalTo("There was some violation.")))
      .andExpect(jsonPath("$.violations", hasSize(1)))
      .andExpect(jsonPath("$.violations[0].type", equalTo("ERROR")))
      .andExpect(jsonPath("$.violations[0].key", equalTo("error-key")))
      .andExpect(jsonPath("$.violations[0].content", equalTo("error-content")));
  }

  @Test
  void verifyCreateSuccess() throws Exception {
    final String content = "{\"codigo\":\"GRP-CODIGO\",\"nome\":\"GRP-NOME\"}";
    when(grupoDocumentoCreateService.create(captor.capture())).thenReturn(grupoDocumentoQualquerAtivo());

    this.mockMvc
      .perform(post("/grupo-documento").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> {
        final GrupoDocumentoVO4Create value = captor.getValue();
        assertEquals("GRP-CODIGO", value.getCodigo());
        assertEquals("GRP-NOME", value.getNome());
      })
      .andExpect(status().isCreated());
  }
}
