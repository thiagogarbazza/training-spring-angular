package com.github.thiagogarbazza.training.springangular.core.documentoesperado;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistente;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoAuditavel;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AbstractObjectPersistenteCriacaoEModificacaoAuditavel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@SuperBuilder
@FieldNameConstants
@ToString(callSuper = true, of = {"documento", "cliente", "dataBase", "situacao"})
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Table(name = "tbl_documento_esperado", schema = "documento_esperado")
@AttributeOverrides({ // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_CREATOR, column = @Column(name = "criador", nullable = false, length = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_LENGTH)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.ATTR_DATE_TIME_CREATOR, column = @Column(name = "criacao", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.ATTR_USER_NAME_MODIFIER, column = @Column(name = "modificador", nullable = true, length = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_LENGTH)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.ATTR_DATE_TIME_MODIFIER, column = @Column(name = "modificacao", nullable = true))
}) // @formatter:on
public class DocumentoEsperado extends AbstractObjectPersistenteCriacaoEModificacaoAuditavel {

  @ManyToOne
  @JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "fk_tbl_documento_esperado_from_tbl_cliente"))
  private Cliente cliente;
  @Column(name = "data_base", nullable = false)
  private LocalDate dataBase;
  @Column(name = "data_limite_entrega", nullable = false)
  private LocalDate dataLimiteEntrega;
  @ManyToOne
  @JoinColumn(name = "documento_id", nullable = false, foreignKey = @ForeignKey(name = "fk_tbl_documento_esperado_from_tbl_documento"))
  private Documento documento;
  @OneToMany(mappedBy = HistoricoSituacaoDocumentoEsperado.Fields.documentoEsperado, cascade = CascadeType.ALL)
  private Collection<HistoricoSituacaoDocumentoEsperado> historicoSituacao;
  @Column(name = "situacao", nullable = false)
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private SituacaoDocumentoEsperado situacao;
}
