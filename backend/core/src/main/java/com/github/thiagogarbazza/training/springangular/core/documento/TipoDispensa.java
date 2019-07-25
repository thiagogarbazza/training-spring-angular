package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import lombok.Getter;

@Getter
public enum TipoDispensa implements EnumIdentifiableWithNome {

  NAO_PERMITE_DISPENSA(0, false, "Não permite dispensa"),
  PERIODO(1, true, "Dispensa por periodo"),
  DATA_BASE(2, true, "Dispensa por data-base");

  private final int id;
  private final String nome;
  private final boolean permiteDispensa;

  TipoDispensa(final int id, final boolean permiteDispensa, final String nome) {
    this.id = id;
    this.permiteDispensa = permiteDispensa;
    this.nome = nome;
  }
}
