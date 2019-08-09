package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum SituacaoGrupoDocumento implements EnumIdentifiableWithDescription {

  ATIVO(1, "Ativo"),
  INATIVO(2, "Inativo");

  public final int id;
  private final String description;

  SituacaoGrupoDocumento(final int id, final String description) {
    this.id = id;
    this.description = description;
  }
}
