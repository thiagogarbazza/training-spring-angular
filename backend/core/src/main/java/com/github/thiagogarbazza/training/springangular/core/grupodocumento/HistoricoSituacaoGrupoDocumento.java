package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistente;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Type;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@FieldNameConstants
@ToString(callSuper = true)
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Table(name = "his_situacao_grupo_documento", schema = "documento")
@AttributeOverrides({ // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_CREATOR, column = @Column(name = "criador", nullable = false, length = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_LENGTH)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.ATTR_DATE_TIME_CREATOR, column = @Column(name = "criacao", nullable = false)),
}) // @formatter:on
public class HistoricoSituacaoGrupoDocumento extends AbstractObjectPersistenteCriacaoAuditavel {

  @ManyToOne
  @JoinColumn(name = "grupo_documento_id", nullable = false, foreignKey = @ForeignKey(name =
    "fk_his_situacao_grupo_documento_from_tbl_grupo_documento"))
  private GrupoDocumento grupoDocumento;
  @Column(name = "motivo", length = 1000)
  private String motivo;
  @Column(name = "situacao", nullable = false)
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private SituacaoGrupoDocumento situacao;
}
