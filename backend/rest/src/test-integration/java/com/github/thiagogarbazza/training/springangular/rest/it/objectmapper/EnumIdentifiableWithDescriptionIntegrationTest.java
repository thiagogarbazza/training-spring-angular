package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo.ExemploDataVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumIdentifiableWithDescriptionIntegrationTest {

  private ObjectMapper objectMapper = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder().build();

  @Test
  void verifyDeserializer() throws Exception {
    assertEquals(ExemploDataVO.ExampleEnumIdentifiableWithDescription.VALOR_01,
      this.objectMapper.readValue("1", ExemploDataVO.ExampleEnumIdentifiableWithDescription.class));
  }

  @Test
  void verifySerializer() throws Exception {
    assertEquals("{\"id\":1,\"description\":\"Valor 01\"}",
      this.objectMapper.writeValueAsString(ExemploDataVO.ExampleEnumIdentifiableWithDescription.VALOR_01));
  }
}
