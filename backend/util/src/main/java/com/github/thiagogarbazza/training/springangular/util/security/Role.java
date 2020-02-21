package com.github.thiagogarbazza.training.springangular.util.security;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum Role implements EnumIdentifiableWithDescription<String> {

  ADMINISTRADOR("ADM_00", "Administrador"),
  FUNCIONARIO("FUNCI", "Funcionário");

  private final String description;
  private final String id;

  Role(final String id, final String description) {
    this.id = id;
    this.description = description;
  }
}
