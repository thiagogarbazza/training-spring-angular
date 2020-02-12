package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@UtilityClass
class OrderingUtils {

  static <T extends OrderableColumn> OrderSpecifier[] union(final T ordenacaoCampo, final OrderableDirection ordenacaoDirecao,
    Collection<OrderSpecifier> sortableDefault) {
    return union(sortableColumn(ordenacaoCampo, ordenacaoDirecao), sortableDefault);
  }

  private static <T extends OrderableColumn> Collection<OrderSpecifier> sortableColumn(final T ordenacaoCampo,
    final OrderableDirection ordenacaoDirecao) {
    return ObjectUtils.allNotNull(ordenacaoCampo, ordenacaoDirecao)
      ? ordenacaoCampo.getOrderSpecifier(ordenacaoDirecao)
      : Collections.emptyList();
  }

  private static OrderSpecifier[] union(Collection<OrderSpecifier> sortableColumn, Collection<OrderSpecifier> sortableDefault) {
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
