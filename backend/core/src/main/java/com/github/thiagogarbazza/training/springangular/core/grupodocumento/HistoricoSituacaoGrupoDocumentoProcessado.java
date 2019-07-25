package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistente;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoAuditavel;
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
@Table(name = "his_situacao_grupo_documento", schema = "documento")
@AttributeOverrides({ // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criador, column = @Column(name = "criador", nullable = false, length = LENGTH_ATTR_CRIADOR)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criacao, column = @Column(name = "criacao", nullable = false))
}) // @formatter:on
public class HistoricoSituacaoGrupoDocumentoProcessado extends AbstractObjectPersistenteCriacaoAuditavel {

  @ManyToOne
  @JoinColumn(name = "grupo_documento_id", nullable = false, foreignKey = @ForeignKey(name = "fk_his_situacao_grupo_documento_from_tbl_grupo_documento"))
  private GrupoDocumento grupoDocumento;
  @Column(name = "situacao", nullable = false)
  private SituacaoGrupoDocumento situacao;
}
