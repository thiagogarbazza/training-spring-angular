package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("Desabilitado até corrigir a conversão de java.time e dos Enuns")
@RestIntegrationTestRunner
class JacksonMapperJavaTimeIntegrationTest {

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void verifyLocalDate() throws Exception {
    final String content = this.objectMapper.writeValueAsString(LocalDate.of(2019, 12, 31));

    assertEquals("2019-12-31", content);
  }

  @Test
  void verifyLocalDateTime() throws Exception {
    final String content = this.objectMapper.writeValueAsString(LocalDateTime.of(2019, 12, 31, 23, 59, 59, 999));

    assertEquals("2019-12-31 23:59:59:999", content);
  }
}
