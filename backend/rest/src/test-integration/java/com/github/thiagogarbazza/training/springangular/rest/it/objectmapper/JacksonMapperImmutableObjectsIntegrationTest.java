package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JacksonMapperImmutableObjectsIntegrationTest {

  private final ObjectMapper objectMapper = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder().build();

  @Test
  void verifyDeserializer() throws Exception {
    assertEquals(ExampleImmutable.newExampleImmutable(), this.objectMapper.readValue(ExampleImmutable.JSON, ExampleImmutable.class));
  }

  @Test
  void verifySerializer() throws Exception {
    assertEquals(ExampleImmutable.JSON, this.objectMapper.writeValueAsString(ExampleImmutable.newExampleImmutable()));
  }

  @Value
  @Builder
  @AllArgsConstructor(access = PRIVATE)
  @NoArgsConstructor(force = true, access = PRIVATE)
  static final class ExampleImmutable {

    static final String JSON = "{\"condition\":true,\"date\":\"2019-01-31\",\"money\":3.14,\"text\":\"Algum texto\"}";

    private final Boolean condition;
    private final LocalDate date;
    private final BigDecimal money;
    private final String text;

    static ExampleImmutable newExampleImmutable() {
      return ExampleImmutable.builder()
        .text("Algum texto")
        .condition(Boolean.TRUE)
        .money(new BigDecimal("3.14"))
        .date(LocalDate.of(2019, 1, 31))
        .build();
    }
  }
}
