package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@ToString
@RequiredArgsConstructor(access = PROTECTED)
public class GrupoDocumentoVO4Create {

  private final String codigo;
  private final String nome;
}
