package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("Desabilitado até corrigir a conversão de java.time e dos Enuns")
@RestIntegrationTestRunner
class EnumIdentifiableWithDescriptionIntegrationTest {

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void vefiricarColecao() throws Exception {
    final String content = this.objectMapper.writeValueAsString(Collections.singleton(CustomEnumIdentifiableWithDescription.ATIVO));

    assertEquals("[{\r\n  \"id\" : 1,\r\n  \"description\" : \"Ativo\"\r\n}]", content);
  }

  @Test
  void vefiricarItem() throws Exception {
    final String content = this.objectMapper.writeValueAsString(CustomEnumIdentifiableWithDescription.ATIVO);

    assertEquals("{\r\n  \"id\" : 1,\r\n  \"description\" : \"Ativo\"\r\n}", content);
  }

  @Getter
  enum CustomEnumIdentifiableWithDescription implements EnumIdentifiableWithDescription<Integer> {

    ATIVO(1, "Ativo"),
    INATIVO(2, "Inativo");

    private final String description;
    private final Integer id;

    CustomEnumIdentifiableWithDescription(final int id, final String description) {
      this.id = id;
      this.description = description;
    }
  }
}
