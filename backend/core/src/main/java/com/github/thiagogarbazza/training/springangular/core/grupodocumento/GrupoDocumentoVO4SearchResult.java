package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.Identifiable;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@ToString
@AllArgsConstructor(access = PRIVATE)
public class GrupoDocumentoVO4SearchResult implements Identifiable {

  private final String codigo;
  private final UUID id;
  private final String nome;

  @QueryProjection
  public GrupoDocumentoVO4SearchResult(final UUID id, final String codigo, final String nome) {
    this.id = id;
    this.codigo = codigo;
    this.nome = nome;
  }
}
