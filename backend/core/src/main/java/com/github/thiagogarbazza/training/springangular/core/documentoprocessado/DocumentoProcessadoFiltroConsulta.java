package com.github.thiagogarbazza.training.springangular.core.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.AbstractSearchFilter;
import com.querydsl.core.types.OrderSpecifier;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Getter
@ToString
@SuperBuilder
public class DocumentoProcessadoFiltroConsulta extends AbstractSearchFilter<DocumentoProcessadoOrdenacaoCampo> {

  private final Collection<UUID> clientes;
  private final Collection<UUID> documentos;
  private final Collection<Long> protocolos;
  private final Collection<SituacaoDocumentoProcessado> situacoes;

  @Override
  protected Collection<OrderSpecifier> defaultOrdering() {
    return Collections.EMPTY_LIST;
  }
}
