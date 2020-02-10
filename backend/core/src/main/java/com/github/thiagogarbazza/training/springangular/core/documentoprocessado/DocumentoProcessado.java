package com.github.thiagogarbazza.training.springangular.core.documentoprocessado;

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
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
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
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
@Table(name = "tbl_documento_processado", schema = "documento_processado")
@AttributeOverrides({ // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false, updatable = false, unique = true, columnDefinition = "CHAR(32)")),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_CREATOR, column = @Column(name = "criador", nullable = false, length = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_LENGTH)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.ATTR_DATE_TIME_CREATOR, column = @Column(name = "criacao", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.ATTR_USER_NAME_MODIFIER, column = @Column(name = "modificador", nullable = true, length = AbstractObjectPersistenteCriacaoAuditavel.ATTR_USER_NAME_LENGTH)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.ATTR_DATE_TIME_MODIFIER, column = @Column(name = "modificacao", nullable = true))
}) // @formatter:on
public class DocumentoProcessado extends AbstractObjectPersistenteCriacaoEModificacaoAuditavel {

  @ManyToOne
  @JoinColumn(name = "cliente_id", nullable = true, foreignKey = @ForeignKey(name = "fk_tbl_documento_processado_from_tbl_cliente"))
  private Cliente cliente;
  @Column(name = "compactado", nullable = true, length = 200)
  private Boolean compactado;
  @Column(name = "data_base", nullable = false)
  private LocalDate dataBase;
  @Column(name = "data_entrega", nullable = false)
  private LocalDate dataEntrega;
  @ManyToOne
  @JoinColumn(name = "documento_id", nullable = true, foreignKey = @ForeignKey(name = "fk_tbl_documento_processado_from_tbl_documento"))
  private Documento documento;
  @Column(name = "mimetype", nullable = true, length = 200)
  private LocalDate mimetype;
  @Column(name = "nome_arquivo", nullable = true, length = 200)
  private LocalDate nomeArquivo;
  @Column(name = "protocolo_recebimento", nullable = true)
  private Long protocoloRecebimento;
  @Column(name = "situacao", nullable = false)
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private SituacaoDocumentoProcessado situacao;
}
