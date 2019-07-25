package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;

public interface OrderByColumn {
  OrderSpecifier getOrderSpecifier(OrderByDirection direction);
}
