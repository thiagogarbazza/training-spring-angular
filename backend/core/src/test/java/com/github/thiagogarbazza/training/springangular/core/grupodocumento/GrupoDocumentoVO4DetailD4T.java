package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AuditEntity;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Collections.singleton;

@UtilityClass
public class GrupoDocumentoVO4DetailD4T {

  public static GrupoDocumentoVO4Detail grupoDocumentoVO4DetailQualquer() {
    return GrupoDocumentoVO4Detail.builder()
      .id(UUID.fromString("df160f6e-e4e5-4fbf-a39f-d92acff9eade"))
      .codigo("GRP-CODIGO")
      .nome("GRP-NOME")
      .situacao(SituacaoGrupoDocumento.ATIVO)
      .creation(AuditEntity.builder()
        .userName("mouse.mickey")
        .dateTime(LocalDateTime.of(2000, 1, 31, 23, 59, 59, 999))
        .build())
      .modification(null)
      .historicoSituacaos(singleton(GrupoDocumentoVO4Detail.HistoricoSituacao.builder()
        .id(UUID.fromString("014f2cc3-ca55-4be9-a392-84850ded3338"))
        .situacao(SituacaoGrupoDocumento.ATIVO)
        .motivo(null)
        .creation(AuditEntity.builder()
          .userName("mouse.mickey")
          .dateTime(LocalDateTime.of(2000, 1, 31, 23, 59, 59, 999))
          .build())
        .build()))
      .build();
  }
}
