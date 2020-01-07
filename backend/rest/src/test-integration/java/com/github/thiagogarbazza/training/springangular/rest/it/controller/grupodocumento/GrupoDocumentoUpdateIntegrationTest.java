package com.github.thiagogarbazza.training.springangular.rest.it.controller.grupodocumento;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.simplemessage.SimpleMessageType;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoUpdateService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Update;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import com.github.thiagogarbazza.violationbuilder.ViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static java.util.Collections.singleton;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class GrupoDocumentoUpdateIntegrationTest {

  @Captor
  private ArgumentCaptor<GrupoDocumentoVO4Update> captor;
  @Autowired
  private WebApplicationContext context;
  @MockBean
  private GrupoDocumentoUpdateService grupoDocumentoUpdateService;
  private MockMvc mockMvc;

  @BeforeEach
  final void setupWebTest() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void verifyUpdateError() throws Exception {
    final String content = "{\"codigo\":null,\"nome\":\"GRP-NOME\"}";
    final SimpleMessage MESSAGEM_ERROR = new SimpleMessage(SimpleMessageType.ERROR, "error-key", "error-content");
    when(grupoDocumentoUpdateService.update(captor.capture())).thenThrow(
      new ViolationException("There was some violation.", singleton(MESSAGEM_ERROR)));

    this.mockMvc
      .perform(put("/grupo-documento/df160f6e-e4e5-4fbf-a39f-d92acff9eade").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> {
        final GrupoDocumentoVO4Update value = captor.getValue();
        assertEquals("df160f6e-e4e5-4fbf-a39f-d92acff9eade", value.getId().toString());
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
  void verifyUpdateSuccess() throws Exception {
    final String content = "{\"codigo\":\"GRP-CODIGO\",\"nome\":\"GRP-NOME\"}";
    when(grupoDocumentoUpdateService.update(captor.capture())).thenReturn(GrupoDocumento.builder().build());

    this.mockMvc
      .perform(put("/grupo-documento/df160f6e-e4e5-4fbf-a39f-d92acff9eade").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> {
        final GrupoDocumentoVO4Update value = captor.getValue();
        assertEquals("df160f6e-e4e5-4fbf-a39f-d92acff9eade", value.getId().toString());
        assertEquals("GRP-CODIGO", value.getCodigo());
        assertEquals("GRP-NOME", value.getNome());
      })
      .andExpect(status().isOk());
  }
}
