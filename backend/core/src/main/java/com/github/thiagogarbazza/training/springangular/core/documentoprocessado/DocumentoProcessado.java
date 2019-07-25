package com.github.thiagogarbazza.training.springangular.core.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
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

import java.time.LocalDate;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
@Table(name = "tbl_documento_processado", schema = "documento_processado")
@AttributeOverrides({ // @formatter:off
  @AttributeOverride(name = AbstractObjectPersistente.Fields.id, column = @Column(name = "id", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criador, column = @Column(name = "criador", nullable = false, length = LENGTH_ATTR_CRIADOR)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoAuditavel.Fields.criacao, column = @Column(name = "criacao", nullable = false)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.Fields.modificador, column = @Column(name = "modificador", nullable = true, length = LENGTH_ATTR_MODIFICADOR)),
  @AttributeOverride(name = AbstractObjectPersistenteCriacaoEModificacaoAuditavel.Fields.modificacao, column = @Column(name = "modificacao", nullable = true))
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
  @Column(name = "situacao", nullable = false, columnDefinition = "tinyint")
  @Type(type = "com.github.thiagogarbazza.training.springangular.util.persistence.integrator.EnumIdentifiableType")
  private SituacaoDocumentoProcessado situacao;
}
