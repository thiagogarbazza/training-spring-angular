package com.github.thiagogarbazza.training.springangular.core.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import lombok.Getter;

@Getter
public enum SituacaoDocumentoProcessado implements EnumIdentifiableWithNome {

  ACEITO(1, "Aceito"),
  EM_PROCESSAMENTO(0, "Em processamento"),
  EXCLUIDO(2, "Excluído"),
  REJEITADO(3, "Rejeitado");

  public final int id;
  private final String nome;

  SituacaoDocumentoProcessado(final int id, final String nome) {
    this.id = id;
    this.nome = nome;
  }
}


