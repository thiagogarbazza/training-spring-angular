package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@MappedSuperclass
@FieldNameConstants
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@EntityListeners({AuditarCriacaoListener.class})
public abstract class AbstractObjectPersistenteCriacaoAuditavel extends AbstractObjectPersistente {

  public static final int LENGTH_ATTR_CRIADOR = 100;

  @Column(name = "criacao", nullable = false)
  private LocalDateTime criacao;
  @Column(name = "criador", nullable = false, length = LENGTH_ATTR_CRIADOR)
  private String criador;
}
