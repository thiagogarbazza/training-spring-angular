package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import lombok.experimental.SuperBuilder;
import lombok.experimental.UtilityClass;

import java.util.Collection;

@UtilityClass
public class SearchFilterD4T {

  public static AbstractSearchFilter newAbstractSearchFilter() {
    return Filter.builder().build();
  }

  public enum OrderFilter implements OrderableColumn {

    SITUACAO(null);

    private final ComparableExpressionBase expression;

    OrderFilter(final ComparableExpressionBase expression) {
      this.expression = expression;
    }

    @Override
    public OrderSpecifier getOrderSpecifier(OrderableDirection direction) {
      return direction.getOrderSpecifier(expression);
    }
  }

  @SuperBuilder
  public static class Filter extends AbstractSearchFilter<OrderFilter> {

    private String text;

    @Override
    protected Collection<OrderSpecifier> defaultOrdering() {
      return null;
    }
  }
}
