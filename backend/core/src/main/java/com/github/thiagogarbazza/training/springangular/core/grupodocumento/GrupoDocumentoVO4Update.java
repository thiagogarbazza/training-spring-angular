package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@ToString
@RequiredArgsConstructor(access = PROTECTED)
public class GrupoDocumentoVO4Update {

  private final String codigo;
  private final UUID id;
  private final String nome;
}
