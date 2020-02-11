package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;

@UtilityClass
class OrderingUtils {

  static OrderSpecifier[] union(Collection<OrderSpecifier> sortableColumn, Collection<OrderSpecifier> sortableDefault) {
    final Collection<OrderSpecifier> orderBy = new ArrayList<>();

    if (CollectionUtils.isNotEmpty(sortableColumn)) {
      orderBy.addAll(sortableColumn);
    }

    if (CollectionUtils.isNotEmpty(sortableDefault)) {
      sortableDefault.forEach(s -> orderBy.add(s.nullsLast()));
    }

    return orderBy.toArray(new OrderSpecifier[0]);
  }
}
