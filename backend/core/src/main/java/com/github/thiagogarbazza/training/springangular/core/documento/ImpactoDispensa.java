package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import lombok.Getter;

@Getter
public enum ImpactoDispensa implements EnumIdentifiableWithNome {

  NAO_FAZER_NADA(0, "Não fazer nada"),
  REJEITAR_DOCUMENTOS_PROCESSADOS(1, "Rejeitar documentos processados");

  private final int id;
  private final String nome;

  ImpactoDispensa(final int id, final String nome) {
    this.id = id;
    this.nome = nome;
  }
}
