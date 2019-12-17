package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collection;

@UtilityClass
class OrderingHelper {

  static OrderSpecifier[] union(OrderSpecifier orderSpecifier, Collection<OrderSpecifier> sortableDefault) {
    OrderSpecifier[] orderBy = new OrderSpecifier[] {};

    if (orderSpecifier != null) {
      orderBy = ArrayUtils.add(orderBy, orderSpecifier);
    }

    for (Object order : sortableDefault) {
      orderBy = ArrayUtils.add(orderBy, ((OrderSpecifier) order).nullsLast());
    }

    return orderBy;
  }
}
