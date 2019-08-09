package com.github.thiagogarbazza.training.springangular.core.documentodispensado;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.AbstractFiltroPaginado;
import com.querydsl.core.types.OrderSpecifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.QDocumentoDispensado.documentoDispensado;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class DocumentoDispensadoFiltroConsulta extends AbstractFiltroPaginado<DocumentoDispensadoOrdenacaoCampo> {

  private Collection<UUID> clientes;
  private LocalDate dataBaseFim;
  private LocalDate dataBaseInicio;
  private Collection<UUID> documentos;
  private Collection<UUID> grupoDocumentos;
  private Collection<SituacaoDocumentoDispensado> situacoes;

  @Override
  public Collection<OrderSpecifier> orderByDefault() {
    return Arrays.asList(
      documentoDispensado.documento.grupoDocumento.codigo.asc(),
      documentoDispensado.documento.codigo.asc(),
      documentoDispensado.cliente.codigo.asc(),
      documentoDispensado.vigencia.inicio.desc()
                        );
  }
}
