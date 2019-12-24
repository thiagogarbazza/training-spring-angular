package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.PreUpdate;

class AuditarModificacaoListener {

  @PreUpdate
  public void preUpdate(AbstractObjectPersistenteCriacaoEModificacaoAuditavel abstractObjectPersistenteCriacaoEModificacaoAuditavel) {
    final AuditEntity auditEntity = AuditEntity.builder()
      .userName("thiago.garbazza")
      .dateTime(LocalDateTime.now())
      .build();

    abstractObjectPersistenteCriacaoEModificacaoAuditavel.setModification(auditEntity);
  }
}
