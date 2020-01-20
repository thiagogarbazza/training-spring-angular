package com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
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

import static com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo.ExemploDataVO.getExemploDataVO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class ExemploRestControllerPostMappingIntegrationTest {

  @Captor
  private ArgumentCaptor<ExemploDataVO> captor;
  @Autowired
  private WebApplicationContext context;
  @MockBean
  private ExemploRestService exemploRestService;
  private MockMvc mockMvc;
  private ObjectMapper objectMapper = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder().build();

  @BeforeEach
  final void beforeEach() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void verifyPostRequestBody() throws Exception {
    final ExemploDataVO exemploDataVO = getExemploDataVO();
    final String content = objectMapper.writeValueAsString(exemploDataVO);

    when(exemploRestService.post(captor.capture())).thenReturn(exemploDataVO);

    this.mockMvc.perform(post("/end-point-exemplo/post").content(content).contentType(APPLICATION_JSON))
      .andDo(result -> assertEquals(exemploDataVO, captor.getValue()))
      .andExpect(status().isOk())
      .andExpect(content().json(content));
  }
}
