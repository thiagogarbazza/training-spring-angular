package com.github.thiagogarbazza.training.springangular.core.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableColumn;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableDirection;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.documentoprocessado.QDocumentoProcessado.documentoProcessado;
import static java.util.Collections.singletonList;

public enum DocumentoProcessadoOrdenacaoCampo implements OrderableColumn {

  CODIGO_CLIENTE(documentoProcessado.cliente.codigo),
  CODIGO_DOCUMENTO(documentoProcessado.documento.codigo),
  DATA_BASE(documentoProcessado.dataBase);

  private final ComparableExpressionBase expression;

  DocumentoProcessadoOrdenacaoCampo(final ComparableExpressionBase expression) {
    this.expression = expression;
  }

  @Override
  public Collection<OrderSpecifier> getOrderSpecifier(OrderableDirection direction) {
    return singletonList(direction.getOrderSpecifier(expression));
  }
}
