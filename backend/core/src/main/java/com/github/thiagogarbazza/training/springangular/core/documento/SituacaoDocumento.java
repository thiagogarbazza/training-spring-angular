package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum SituacaoDocumento implements EnumIdentifiableWithDescription {

  ATIVO(1, "Ativo"),
  EM_CRIACAO(0, "Em criação"),
  ENCERRADO(2, "Encerrado");

  private final int id;
  private final String description;

  SituacaoDocumento(final int id, final String description) {
    this.id = id;
    this.description = description;
  }
}



