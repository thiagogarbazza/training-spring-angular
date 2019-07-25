package com.github.thiagogarbazza.training.springangular.core.cliente;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistente;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoAuditavel;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoEModificacaoAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import static com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoAuditavel.LENGTH_ATTR_CRIADOR;
import static com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoEModificacaoAuditavel.LENGTH_ATTR_MODIFICADOR;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@ToString(callSuper = true)
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Table(name = "tbl_cliente", schema = "cliente", indexes = {
  @Index(name = "idx_tbl_cliente_codigo", columnList = "codigo", unique = true)
})
@AttributeOverrides({  // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criador, column = @Column(name = "criador", nullable = false, length = LENGTH_ATTR_CRIADOR)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criacao, column = @Column(name = "criacao", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.Fields.modificador, column = @Column(name = "modificador", nullable = true, length = LENGTH_ATTR_MODIFICADOR)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.Fields.modificacao, column = @Column(name = "modificacao", nullable = true))
}) // @formatter:on
public class Cliente extends AbstractObjectPersistenteCriacaoEModificacaoAuditavel {

  @Column(name = "codigo", nullable = false, length = 50)
  private String codigo;
  @Column(name = "nome", nullable = false, length = 200)
  private String nome;
}
