package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo.ExemploDataVO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumObjectIntegrationTest {

  private static ObjectMapper objectMapper = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder().build();

  @Test
  void verifyDeserializer() throws Exception {
    assertEquals(ExemploDataVO.ExampleEnumObject.VALOR_01, this.objectMapper.readValue("\"VALOR_01\"", ExemploDataVO.ExampleEnumObject.class));
  }

  @Test
  void verifySerializer() throws Exception {

    assertEquals("\"VALOR_01\"", this.objectMapper.writeValueAsString(ExemploDataVO.ExampleEnumObject.VALOR_01));
  }

  @BeforeAll
  static void beforeAll() {

    objectMapper.registerModule(new SimpleModule()
      .addSerializer(new EnumObjectSerializer()));
  }
}
