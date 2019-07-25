package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.PrePersist;

class AuditarCriacaoListener {

  @PrePersist
  public void prePersist(AbstractObjectPersistenteCriacaoAuditavel abstractObjectPersistenteCriacaoAuditavel) {
    abstractObjectPersistenteCriacaoAuditavel.setCriacao(LocalDateTime.now());
    abstractObjectPersistenteCriacaoAuditavel.setCriador("thiago.garbazza");
  }
}
