package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;

import static lombok.AccessLevel.PRIVATE;

@With
@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(force = true, access = PRIVATE)
public class GrupoDocumentoVO4Create {

  private final String codigo;
  private final String nome;
}
