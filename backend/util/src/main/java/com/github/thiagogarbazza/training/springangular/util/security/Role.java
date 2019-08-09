package com.github.thiagogarbazza.training.springangular.util.security;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum Role implements EnumIdentifiableWithDescription {

  ADMINISTRADOR(0, "SCRD005", "Administrador");

  private final String codigo;
  private final int id;
  private final String description;

  Role(final int id, final String codigo, final String description) {
    this.id = id;
    this.codigo = codigo;
    this.description = description;
  }
}
