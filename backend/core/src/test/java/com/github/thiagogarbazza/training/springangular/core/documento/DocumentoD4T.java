package com.github.thiagogarbazza.training.springangular.core.documento;

import lombok.experimental.UtilityClass;

import static com.github.thiagogarbazza.training.springangular.core.documento.SituacaoDocumento.ATIVO;
import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoD4T.grupoDocumentoABC;
import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoD4T.grupoDocumentoXYZ;

@UtilityClass
public class DocumentoD4T {

  public static Documento documentoABC01() {
    return Documento.builder()
      .grupoDocumento(grupoDocumentoABC())
      .codigo("ABC-01")
      .nome("ABC-01")
      .situacao(ATIVO)
      .build();
  }

  public static Documento documentoXYZ01() {
    return Documento.builder()
      .grupoDocumento(grupoDocumentoXYZ())
      .codigo("XYZ-01")
      .nome("XYZ-01")
      .situacao(ATIVO)
      .build();
  }
}
