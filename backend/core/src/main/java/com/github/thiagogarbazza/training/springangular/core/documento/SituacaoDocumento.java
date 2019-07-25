package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import lombok.Getter;

@Getter
public enum SituacaoDocumento implements EnumIdentifiableWithNome {

  ATIVO(1, "Ativo"),
  EM_CRIACAO(0, "Em criação"),
  ENCERRADO(2, "Encerrado");

  private final int id;
  private final String nome;

  SituacaoDocumento(final int id, final String nome) {
    this.id = id;
    this.nome = nome;
  }
}



