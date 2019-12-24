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
@EntityListeners({AuditarCriacaoListener.class})
public abstract class AbstractObjectPersistenteCriacaoAuditavel extends AbstractObjectPersistente {

  public static final String ATTR_DATE_TIME_CREATOR = "creation.dateTime";
  public static final String ATTR_USER_NAME_CREATOR = "creation.userName";
  public static final int ATTR_USER_NAME_LENGTH = 100;

  @Embedded
  private AuditEntity creation;
}
