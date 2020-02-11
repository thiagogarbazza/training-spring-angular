package com.github.thiagogarbazza.training.springangular.core.documentodispensado;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableColumn;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableDirection;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.QDocumentoDispensado.documentoDispensado;
import static java.util.Collections.singletonList;

public enum DocumentoDispensadoOrdenacaoCampo implements OrderableColumn {

  CODIGO_CLIENTE(documentoDispensado.cliente.codigo),
  CODIGO_DOCUMENTO(documentoDispensado.documento.codigo),
  DATA_BASE(documentoDispensado.vigencia.inicio);

  private final ComparableExpressionBase expression;

  DocumentoDispensadoOrdenacaoCampo(final ComparableExpressionBase expression) {
    this.expression = expression;
  }

  @Override
  public Collection<OrderSpecifier> getOrderSpecifier(OrderableDirection direction) {
    return singletonList(direction.getOrderSpecifier(expression));
  }
}
