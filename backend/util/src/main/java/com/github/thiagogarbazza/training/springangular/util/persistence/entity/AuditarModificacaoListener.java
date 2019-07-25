package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.PreUpdate;

class AuditarModificacaoListener {

  @PreUpdate
  public void preUpdate(AbstractObjectPersistenteCriacaoEModificacaoAuditavel abstractObjectPersistenteCriacaoEModificacaoAuditavel) {
    abstractObjectPersistenteCriacaoEModificacaoAuditavel.setModificacao(LocalDateTime.now());
    abstractObjectPersistenteCriacaoEModificacaoAuditavel.setModificador("thiago.garbazza");
  }
}
