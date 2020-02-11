package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableColumn;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableDirection;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.documento.QDocumento.documento;
import static java.util.Collections.singletonList;

public enum DocumentoOrdenacaoCampo implements OrderableColumn {

  CODIGO(documento.codigo),
  SITUACAO(documento.situacao);

  private final ComparableExpressionBase expression;

  DocumentoOrdenacaoCampo(final ComparableExpressionBase expression) {
    this.expression = expression;
  }

  @Override
  public Collection<OrderSpecifier> getOrderSpecifier(OrderableDirection direction) {
    return singletonList(direction.getOrderSpecifier(expression));
  }
}
