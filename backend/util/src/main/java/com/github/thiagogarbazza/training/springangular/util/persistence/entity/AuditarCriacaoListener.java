package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.PrePersist;

class AuditarCriacaoListener {

  @PrePersist
  public void prePersist(AbstractObjectPersistenteCriacaoAuditavel abstractObjectPersistenteCriacaoAuditavel) {
    final AuditEntity auditEntity = AuditEntity.builder()
      .userName("thiago.garbazza")
      .dateTime(LocalDateTime.now())
      .build();

    abstractObjectPersistenteCriacaoAuditavel.setCreation(auditEntity);
  }
}
