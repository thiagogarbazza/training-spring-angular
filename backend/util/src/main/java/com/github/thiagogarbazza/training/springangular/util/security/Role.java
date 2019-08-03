package com.github.thiagogarbazza.training.springangular.util.security;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import lombok.Getter;

@Getter
public enum Role implements EnumIdentifiableWithNome {

  ADMINISTRADOR(0, "SCRD005", "Administrador");

  private final String codigo;
  private final int id;
  private final String nome;

  Role(final int id, final String codigo, final String nome) {
    this.id = id;
    this.codigo = codigo;
    this.nome = nome;
  }
}
