package com.github.thiagogarbazza.training.springangular.core.documentodispensado;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderByColumn;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderByDirection;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.QDocumentoDispensado.documentoDispensado;

public enum DocumentoDispensadoOrdenacaoCampo implements OrderByColumn {

  CODIGO_CLIENTE(documentoDispensado.cliente.codigo),
  CODIGO_DOCUMENTO(documentoDispensado.documento.codigo),
  DATA_BASE(documentoDispensado.vigencia.inicio);

  private final ComparableExpressionBase expression;

  DocumentoDispensadoOrdenacaoCampo(final ComparableExpressionBase expression) {
    this.expression = expression;
  }

  @Override
  public OrderSpecifier getOrderSpecifier(OrderByDirection direction) {
    return direction.getOrderSpecifier(expression);
  }
}
