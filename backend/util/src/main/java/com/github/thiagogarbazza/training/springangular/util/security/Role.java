package com.github.thiagogarbazza.training.springangular.util.security;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum Role implements EnumIdentifiableWithDescription<String> {

  ADMINISTRADOR("STR005", "Administrador");

  private final String description;
  private final String id;

  Role(final String id, final String description) {
    this.id = id;
    this.description = description;
  }
}
