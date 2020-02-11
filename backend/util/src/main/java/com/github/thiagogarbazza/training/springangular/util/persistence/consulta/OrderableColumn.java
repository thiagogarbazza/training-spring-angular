package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;

import java.util.Collection;

public interface OrderableColumn {

  Collection<OrderSpecifier> getOrderSpecifier(OrderableDirection direction);
}
