package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@SuperBuilder
@ToString(of = {"id"})
@MappedSuperclass
@EqualsAndHashCode
@FieldNameConstants
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public abstract class AbstractObjectPersistente implements Identifiable<UUID> {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false, updatable = false, unique = true)
  private UUID id;

  public final boolean isNew() {
    return isNull(this.id);
  }
}
