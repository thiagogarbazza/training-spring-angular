package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum ImpactoDispensa implements EnumIdentifiableWithDescription<Integer> {

  NAO_FAZER_NADA(0, "Não fazer nada"),
  REJEITAR_DOCUMENTOS_PROCESSADOS(1, "Rejeitar documentos processados");

  private final Integer id;
  private final String description;

  ImpactoDispensa(final int id, final String description) {
    this.id = id;
    this.description = description;
  }
}
