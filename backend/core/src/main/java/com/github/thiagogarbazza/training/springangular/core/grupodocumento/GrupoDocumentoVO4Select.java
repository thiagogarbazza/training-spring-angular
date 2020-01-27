package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.Identifiable;
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
public class GrupoDocumentoVO4Select implements Identifiable<UUID> {

  private String codigo;
  private UUID id;
  private String nome;

  @QueryProjection
  public GrupoDocumentoVO4Select(final UUID id, final String codigo, final String nome) {
    this.id = id;
    this.codigo = codigo;
    this.nome = nome;
  }
}
