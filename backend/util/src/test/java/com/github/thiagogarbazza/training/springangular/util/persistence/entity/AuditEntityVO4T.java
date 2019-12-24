package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class AuditEntityVO4T {

  public static AuditEntity auditEntityCreationBuilder() {
    return AuditEntity.builder()
      .userName("mouse.mickey")
      .dateTime(LocalDateTime.of(2000, 1, 31, 0, 0, 0))
      .build();
  }

  public static AuditEntity auditEntityModificationBuilder() {
    return AuditEntity.builder()
      .userName("duck.donald")
      .dateTime(LocalDateTime.now())
      .build();
  }
}
