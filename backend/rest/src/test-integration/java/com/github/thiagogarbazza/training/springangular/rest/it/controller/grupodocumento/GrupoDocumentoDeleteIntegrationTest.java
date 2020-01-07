package com.github.thiagogarbazza.training.springangular.rest.it.controller.grupodocumento;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.simplemessage.SimpleMessageType;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoDeleteService;
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

import java.util.UUID;

import static java.util.Collections.singleton;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class GrupoDocumentoDeleteIntegrationTest {

  @Captor
  private ArgumentCaptor<UUID> captor;
  @Autowired
  private WebApplicationContext context;
  @MockBean
  private GrupoDocumentoDeleteService grupoDocumentoDeleteService;
  private MockMvc mockMvc;

  @BeforeEach
  final void setupWebTest() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void verifyDeleteError() throws Exception {
    final SimpleMessage MESSAGEM_ERROR = new SimpleMessage(SimpleMessageType.ERROR, "error-key", "error-content");
    doThrow(new ViolationException("There was some violation.", singleton(MESSAGEM_ERROR)))
      .when(grupoDocumentoDeleteService).delete(captor.capture());

    this.mockMvc
      .perform(delete("/grupo-documento/df160f6e-e4e5-4fbf-a39f-d92acff9eade"))
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
  void verifyDeleteSuccess() throws Exception {
    doNothing().when(grupoDocumentoDeleteService).delete(captor.capture());

    this.mockMvc
      .perform(delete("/grupo-documento/df160f6e-e4e5-4fbf-a39f-d92acff9eade"))
      .andDo(result -> {
        final UUID value = captor.getValue();
        assertEquals("df160f6e-e4e5-4fbf-a39f-d92acff9eade", value.toString());
      })
      .andExpect(status().isOk());
  }
}
