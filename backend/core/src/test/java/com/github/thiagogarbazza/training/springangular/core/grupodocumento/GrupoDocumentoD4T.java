package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GrupoDocumentoD4T {

  public static GrupoDocumento grupoDocumentoAtivoQualquer() {
    return GrupoDocumento.builder()
      .codigo("GRP-CODIGO-A")
      .nome("GRP-NOME Ativo")
      .situacao(SituacaoGrupoDocumento.ATIVO)
      .build();
  }

  public static GrupoDocumento grupoDocumentoInativoQualquer() {
    return GrupoDocumento.builder()
      .codigo("GRP-CODIGO-I")
      .nome("GRP-NOME Inativo")
      .situacao(SituacaoGrupoDocumento.INATIVO)
      .build();
  }
}
