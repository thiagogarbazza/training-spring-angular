package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.Identifiable;
import com.github.thiagogarbazza.training.springangular.util.security.Actions;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class GrupoDocumentoVO4SearchResult implements Identifiable {

  private Actions actions;
  private String codigo;
  private UUID id;
  private String nome;
  private SituacaoGrupoDocumento situacao;

  @QueryProjection
  public GrupoDocumentoVO4SearchResult(final UUID id, final String codigo, final String nome, final SituacaoGrupoDocumento situacao) {
    this.actions = new Actions();
    this.id = id;
    this.codigo = codigo;
    this.nome = nome;
    this.situacao = situacao;
  }
}
