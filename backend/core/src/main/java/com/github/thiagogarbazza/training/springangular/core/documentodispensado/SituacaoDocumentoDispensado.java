package com.github.thiagogarbazza.training.springangular.core.documentodispensado;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import lombok.Getter;

@Getter
public enum SituacaoDocumentoDispensado implements EnumIdentifiableWithNome {

  ATIVO(1, "Ativo"),
  INATIVO(2, "Inativo");

  private final int id;
  private final String nome;

  SituacaoDocumentoDispensado(final int id, final String nome) {
    this.id = id;
    this.nome = nome;
  }
}
