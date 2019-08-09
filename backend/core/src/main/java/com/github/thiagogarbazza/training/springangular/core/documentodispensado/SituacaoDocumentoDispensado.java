package com.github.thiagogarbazza.training.springangular.core.documentodispensado;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum SituacaoDocumentoDispensado implements EnumIdentifiableWithDescription {

  ATIVO(1, "Ativo"),
  INATIVO(2, "Inativo");

  private final int id;
  private final String description;

  SituacaoDocumentoDispensado(final int id, final String description) {
    this.id = id;
    this.description = description;
  }
}
