package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Audited
@SuperBuilder
@ToString(callSuper = true, of = {"code"})
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Table(name = "tbl_simple_entity_audited_a", schema = "zzt_test", indexes = {
  @Index(name = "idx_tbl_simple_entity_audited_a_code", columnList = "code", unique = true)
})
@AttributeOverrides({ // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false)),
}) // @formatter:on
class SimpleEntityAudited_A extends AbstractObjectPersistente {

  @Column(name = "code", nullable = false, length = 50)
  private String code;
  @Column(name = "description", nullable = false, length = 50)
  private String description;
}
