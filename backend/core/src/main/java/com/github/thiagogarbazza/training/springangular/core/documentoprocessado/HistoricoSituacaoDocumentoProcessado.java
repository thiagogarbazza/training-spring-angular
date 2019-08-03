package com.github.thiagogarbazza.training.springangular.core.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistente;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoAuditavel.LENGTH_ATTR_CRIADOR;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@ToString(callSuper = true)
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Table(name = "his_situacao_documento_processado", schema = "documento_processado")
@AttributeOverrides({ // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criador, column = @Column(name = "criador", nullable = false, length = LENGTH_ATTR_CRIADOR)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criacao, column = @Column(name = "criacao", nullable = false))
}) // @formatter:on
public class HistoricoSituacaoDocumentoProcessado extends AbstractObjectPersistenteCriacaoAuditavel {

  @ManyToOne
  @JoinColumn(name = "documento_processado_id", nullable = false, foreignKey = @ForeignKey(name = "fk_his_situacao_documento_processado_from_tbl_documento_processado"))
  private DocumentoProcessado documentoProcessado;
  @Column(name = "situacao", nullable = false)
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private SituacaoDocumentoProcessado situacao;
}
