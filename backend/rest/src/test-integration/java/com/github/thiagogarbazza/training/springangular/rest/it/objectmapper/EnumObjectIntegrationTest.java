package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo.ExemploDataVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumObjectIntegrationTest {

  private final ObjectMapper objectMapper = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder().build();

  @Test
  void verifyDeserializer() throws Exception {
    assertEquals(ExemploDataVO.ExampleEnumObject.VALOR_01, this.objectMapper.readValue("\"VALOR_01\"", ExemploDataVO.ExampleEnumObject.class));
  }

  @Test
  void verifySerializer() throws Exception {

    assertEquals("\"VALOR_01\"", this.objectMapper.writeValueAsString(ExemploDataVO.ExampleEnumObject.VALOR_01));
  }
}
