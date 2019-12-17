package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;

public enum OrderableDirection {

  ASC() {
    @Override
    public OrderSpecifier getOrderSpecifier(ComparableExpressionBase expression) {
      return expression.asc().nullsLast();
    }
  },

  DESC() {
    @Override
    public OrderSpecifier getOrderSpecifier(ComparableExpressionBase expression) {
      return expression.desc().nullsFirst();
    }
  };

  public abstract OrderSpecifier getOrderSpecifier(ComparableExpressionBase expression);
}
