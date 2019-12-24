package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AuditEntityVO4T;
import lombok.experimental.UtilityClass;

import java.util.UUID;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento.ATIVO;
import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento.INATIVO;

@UtilityClass
public class GrupoDocumentoVO4T {

  public static GrupoDocumento grupoDocumentoQualquerAtivo() {
    return GrupoDocumento.builder()
      .id(UUID.fromString("ffb66d3d-bf5f-4451-a297-10dd7d93f1f2"))
      .codigo("ABC")
      .nome("ABC")
      .situacao(ATIVO)
      .creation(AuditEntityVO4T.auditEntityCreationBuilder())
      .modification(AuditEntityVO4T.auditEntityModificationBuilder())
      .build();
  }

  public static GrupoDocumento grupoDocumentoQualquerInativo() {
    return GrupoDocumento.builder()
      .id(UUID.fromString("b8673fe1-5bd9-49d8-b66c-933081527958"))
      .codigo("XYZ")
      .nome("XYZ")
      .situacao(INATIVO)
      .creation(AuditEntityVO4T.auditEntityCreationBuilder())
      .modification(AuditEntityVO4T.auditEntityModificationBuilder())
      .build();
  }
}
