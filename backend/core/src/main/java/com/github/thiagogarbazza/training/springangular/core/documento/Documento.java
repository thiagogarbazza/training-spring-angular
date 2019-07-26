package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.util.persistence.Periodo;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistente;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoAuditavel;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoEModificacaoAuditavel;
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
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_documento", schema = "documento", indexes = {
  @Index(name = "idx_tbl_documento_codigo", columnList = "codigo", unique = true)
})
@AttributeOverrides({ // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criador, column = @Column(name = "criador", nullable = false, length = LENGTH_ATTR_CRIADOR)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criacao, column = @Column(name = "criacao", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.Fields.modificador, column = @Column(name = "modificador", nullable = true, length = LENGTH_ATTR_MODIFICADOR)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.Fields.modificacao, column = @Column(name = "modificacao", nullable = true))
})  // @formatter:on
public class Documento extends AbstractObjectPersistenteCriacaoEModificacaoAuditavel {

  @Column(name = "codigo", nullable = false, length = 50)
  private String codigo;
  @ManyToOne
  @JoinColumn(name = "grupo_documento_id", nullable = false, foreignKey = @ForeignKey(name = "fk_tbl_documento_from_tbl_grupo_documento"))
  private GrupoDocumento grupoDocumento;
  @Column(name = "impacto_dispensa", nullable = true, columnDefinition = "tinyint")
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private ImpactoDispensa impactoDispensa;
  @Column(name = "nome", nullable = false, length = 200)
  private String nome;
  @Column(name = "periodicidade", nullable = false, columnDefinition = "tinyint")
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private Periodicidade periodicidade;
  @Column(name = "situacao", nullable = false, columnDefinition = "tinyint")
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private SituacaoDocumento situacao;
  @Column(name = "tipo_dispensa", nullable = false, columnDefinition = "tinyint")
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private TipoDispensa tipoDispensa;
  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = Periodo.Fields.inicio, column = @Column(name = "vigencia_inicio", nullable = false)),
    @AttributeOverride(name = Periodo.Fields.fim, column = @Column(name = "vigencia_fim"))
  })
  private Periodo vigencia;
}
