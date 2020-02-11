package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableColumn;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableDirection;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.QGrupoDocumento.grupoDocumento;
import static java.util.Collections.singletonList;

public enum GrupoDocumentoSortableColumns implements OrderableColumn {

  CODIGO(grupoDocumento.codigo),
  SITUACAO(grupoDocumento.situacao);

  private final ComparableExpressionBase expression;

  GrupoDocumentoSortableColumns(final ComparableExpressionBase expression) {
    this.expression = expression;
  }

  @Override
  public Collection<OrderSpecifier> getOrderSpecifier(OrderableDirection direction) {
    return singletonList(direction.getOrderSpecifier(expression));
  }
}
