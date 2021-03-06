package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.Identifiable;
import com.github.thiagogarbazza.training.springangular.util.security.Actions;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.With;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@With
@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(force = true, access = PRIVATE)
public class GrupoDocumentoVO4SearchResult implements Identifiable<UUID> {

  private final Actions actions;
  private final String codigo;
  private final UUID id;
  private final String nome;
  private final SituacaoGrupoDocumento situacao;

  @QueryProjection
  public GrupoDocumentoVO4SearchResult(final UUID id, final String codigo, final String nome, final SituacaoGrupoDocumento situacao) {
    this.id = id;
    this.codigo = codigo;
    this.nome = nome;
    this.situacao = situacao;
    this.actions = Actions.createActions();
  }
}
