package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistente;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoAuditavel;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoEModificacaoAuditavel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import java.util.Collection;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Table(name = "tbl_grupo_documento", schema = "documento", indexes = {
  @Index(name = "idx_tbl_grupo_documento_codigo", columnList = "codigo", unique = true)
})
@AttributeOverrides({ // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_CREATOR, column = @Column(name = "criador", nullable = false, length = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_LENGTH)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.ATTR_DATE_TIME_CREATOR, column = @Column(name = "criacao", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.ATTR_USER_NAME_MODIFIER, column = @Column(name = "modificador", nullable = true, length = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_LENGTH)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.ATTR_DATE_TIME_MODIFIER, column = @Column(name = "modificacao", nullable = true))
}) // @formatter:on
public class GrupoDocumento extends AbstractObjectPersistenteCriacaoEModificacaoAuditavel {

  @Column(name = "codigo", nullable = false, length = 50)
  private String codigo;
  @OneToMany(mappedBy = HistoricoSituacaoGrupoDocumento.Fields.grupoDocumento)
  private Collection<HistoricoSituacaoGrupoDocumento> historicoSituacaoGrupoDocumentos;
  @Column(name = "nome", nullable = false, length = 100)
  private String nome;
  @Column(name = "situacao", nullable = false)
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private SituacaoGrupoDocumento situacao;
}
