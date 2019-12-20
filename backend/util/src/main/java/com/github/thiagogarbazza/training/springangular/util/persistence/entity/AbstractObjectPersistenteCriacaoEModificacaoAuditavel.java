package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@FieldNameConstants
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@EntityListeners({AuditarModificacaoListener.class})
public abstract class AbstractObjectPersistenteCriacaoEModificacaoAuditavel extends AbstractObjectPersistenteCriacaoAuditavel {

  public static final int LENGTH_ATTR_MODIFICADOR = 100;

  @Column(name = "modificacao")
  private LocalDateTime modificacao;
  @Column(name = "modificador", length = LENGTH_ATTR_MODIFICADOR)
  private String modificador;
}
