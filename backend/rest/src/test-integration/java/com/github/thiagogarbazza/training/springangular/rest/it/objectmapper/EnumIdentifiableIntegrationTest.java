package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo.ExemploDataVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumIdentifiableIntegrationTest {

  private ObjectMapper objectMapper = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder().build();

  @Test
  void verifyDeserializer() throws Exception {
    assertEquals(ExemploDataVO.ExampleEnumIdentifiable.VALOR_01, this.objectMapper.readValue("1", ExemploDataVO.ExampleEnumIdentifiable.class));
  }

  @Test
  void verifySerializer() throws Exception {
    assertEquals("{\"id\":1,\"description\":\"VALOR_01\"}", this.objectMapper.writeValueAsString(ExemploDataVO.ExampleEnumIdentifiable.VALOR_01));
  }
}
