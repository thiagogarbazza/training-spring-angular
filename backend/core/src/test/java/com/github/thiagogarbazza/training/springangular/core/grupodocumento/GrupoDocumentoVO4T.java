package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import lombok.experimental.UtilityClass;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento.ATIVO;

@UtilityClass
public class GrupoDocumentoVO4T {

  public static GrupoDocumento grupoDocumentoABC() {
    return GrupoDocumento.builder()
      .codigo("ABC")
      .nome("ABC")
      .situacao(ATIVO)
      .build();
  }

  public static GrupoDocumento grupoDocumentoXYZ() {
    return GrupoDocumento.builder()
      .codigo("XYZ")
      .nome("XYZ")
      .situacao(ATIVO)
      .build();
  }
}
