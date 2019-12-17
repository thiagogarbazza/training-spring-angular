package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;

public interface OrderableColumn {

  OrderSpecifier getOrderSpecifier(OrderableDirection direction);
}
