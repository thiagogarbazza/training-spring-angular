package com.github.thiagogarbazza.training.springangular.core.documentoesperado;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import lombok.Getter;

@Getter
public enum SituacaoDocumentoEsperado implements EnumIdentifiableWithNome {

  ESPERADO(1, "Esperado"),
  NAO_ESPERADO(2, "Não esperado");

  public final int id;
  private final String nome;

  SituacaoDocumentoEsperado(final int id, final String nome) {
    this.id = id;
    this.nome = nome;
  }
}
