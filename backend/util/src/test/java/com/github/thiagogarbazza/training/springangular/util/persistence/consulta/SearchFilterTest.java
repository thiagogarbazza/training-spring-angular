package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchFilterTest {

  @Test
  void verifyIsEmpty() {
    assertTrue(SearchFilterD4T.Filter.builder().build().isEmpty());
    assertFalse(SearchFilterD4T.Filter.builder().text("Any text").build().isEmpty());
    assertFalse(SearchFilterD4T.Filter.builder().numeroPagina(5).build().isEmpty());
    assertFalse(SearchFilterD4T.Filter.builder().quantidadePorPagina(5).build().isEmpty());
    assertFalse(SearchFilterD4T.Filter.builder().ordenacaoCampo(SearchFilterD4T.OrderFilter.SITUACAO).build().isEmpty());
    assertFalse(SearchFilterD4T.Filter.builder().ordenacaoDirecao(OrderableDirection.DESC).build().isEmpty());
  }
}
