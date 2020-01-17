package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo.ExemploDataVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumSimplesIntegrationTest {

  private final ObjectMapper objectMapper = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder().build();

  @Test
  void verifyDeserializer() throws Exception {
    assertEquals(ExemploDataVO.ExampleEnumSimples.VALOR_01, this.objectMapper.readValue("\"VALOR_01\"", ExemploDataVO.ExampleEnumSimples.class));
  }

  @Test
  void verifySerializer() throws Exception {
    assertEquals("\"VALOR_01\"", this.objectMapper.writeValueAsString(ExemploDataVO.ExampleEnumSimples.VALOR_01));
  }
}
