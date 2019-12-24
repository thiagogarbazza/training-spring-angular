package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@EntityListeners({AuditarModificacaoListener.class})
public abstract class AbstractObjectPersistenteCriacaoEModificacaoAuditavel extends AbstractObjectPersistenteCriacaoAuditavel {

  public static final String ATTR_DATE_TIME_MODIFIER = "modification.dateTime";
  public static final String ATTR_USER_NAME_MODIFIER = "modification.userName";

  @Embedded
  private AuditEntity modification;
}
