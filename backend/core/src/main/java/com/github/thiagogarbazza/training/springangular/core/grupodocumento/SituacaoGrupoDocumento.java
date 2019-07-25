package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import lombok.Getter;

@Getter
public enum SituacaoGrupoDocumento implements EnumIdentifiableWithNome {

  ATIVO(1, "Ativo"),
  INATIVO(2, "Inativo");

  public final int id;
  private final String nome;

  SituacaoGrupoDocumento(final int id, final String nome) {
    this.id = id;
    this.nome = nome;
  }
}
