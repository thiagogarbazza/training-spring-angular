package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum TipoDispensa implements EnumIdentifiableWithDescription {

  NAO_PERMITE_DISPENSA(0, false, "Não permite dispensa"),
  PERIODO(1, true, "Dispensa por periodo"),
  DATA_BASE(2, true, "Dispensa por data-base");

  private final int id;
  private final String description;
  private final boolean permiteDispensa;

  TipoDispensa(final int id, final boolean permiteDispensa, final String description) {
    this.id = id;
    this.permiteDispensa = permiteDispensa;
    this.description = description;
  }
}
