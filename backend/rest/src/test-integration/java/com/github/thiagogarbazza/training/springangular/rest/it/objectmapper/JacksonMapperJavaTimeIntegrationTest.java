package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JacksonMapperJavaTimeIntegrationTest {

  private final ObjectMapper objectMapper = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder().build();

  @Test
  void verifyLocalDateDeserializer() throws Exception {
    assertEquals(LocalDate.of(2019, 12, 31), this.objectMapper.readValue("\"2019-12-31\"", LocalDate.class));
  }

  @Test
  void verifyLocalDateSerializer() throws Exception {
    assertEquals("\"2019-12-31\"", this.objectMapper.writeValueAsString(LocalDate.of(2019, 12, 31)));
  }

  @Test
  void verifyLocalDateTimeDeserializer() throws Exception {
    assertEquals(LocalDateTime.of(2019, 12, 31, 23, 59, 59), this.objectMapper.readValue("\"2019-12-31T23:59:59\"", LocalDateTime.class));
  }

  @Test
  void verifyLocalDateTimeSerializer() throws Exception {
    assertEquals("\"2019-12-31T23:59:59\"", this.objectMapper.writeValueAsString(LocalDateTime.of(2019, 12, 31, 23, 59, 59)));
  }
}
