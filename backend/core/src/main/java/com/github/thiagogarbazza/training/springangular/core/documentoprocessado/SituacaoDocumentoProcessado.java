package com.github.thiagogarbazza.training.springangular.core.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum SituacaoDocumentoProcessado implements EnumIdentifiableWithDescription {

  ACEITO(1, "Aceito"),
  EM_PROCESSAMENTO(0, "Em processamento"),
  EXCLUIDO(2, "Excluído"),
  REJEITADO(3, "Rejeitado");

  public final int id;
  private final String description;

  SituacaoDocumentoProcessado(final int id, final String description) {
    this.id = id;
    this.description = description;
  }
}


