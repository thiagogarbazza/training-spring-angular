package com.github.thiagogarbazza.training.springangular.core.documentoesperado;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum SituacaoDocumentoEsperado implements EnumIdentifiableWithDescription<Integer> {

  ESPERADO(1, "Esperado"),
  NAO_ESPERADO(2, "Não esperado");

  private final Integer id;
  private final String description;

  SituacaoDocumentoEsperado(final int id, final String description) {
    this.id = id;
    this.description = description;
  }
}
