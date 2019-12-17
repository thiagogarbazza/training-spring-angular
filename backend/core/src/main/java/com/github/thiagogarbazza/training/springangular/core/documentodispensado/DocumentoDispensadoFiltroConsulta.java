package com.github.thiagogarbazza.training.springangular.core.documentodispensado;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.AbstractSearchFilter;
import com.querydsl.core.types.OrderSpecifier;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.QDocumentoDispensado.documentoDispensado;

@Getter
@ToString
@SuperBuilder
public class DocumentoDispensadoFiltroConsulta extends AbstractSearchFilter<DocumentoDispensadoOrdenacaoCampo> {

  private final Collection<UUID> clientes;
  private final Collection<UUID> documentos;
  private final Collection<UUID> grupoDocumentos;
  private final Collection<SituacaoDocumentoDispensado> situacoes;
  private final LocalDate vigenciaFim;
  private final LocalDate vigenciaInicio;

  @Override
  public Collection<OrderSpecifier> defaultOrdering() {
    return Arrays.asList(
      documentoDispensado.documento.grupoDocumento.codigo.asc(),
      documentoDispensado.documento.codigo.asc(),
      documentoDispensado.cliente.codigo.asc(),
      documentoDispensado.vigencia.inicio.desc()
                        );
  }
}
