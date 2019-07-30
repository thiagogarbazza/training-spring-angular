package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Collections;
import java.util.List;

public abstract class CustomQueryDslRepositorySupport<E> extends QuerydslRepositorySupport {

  protected CustomQueryDslRepositorySupport(Class<E> domainClass) {
    super(domainClass);
  }

  protected <T> CustomPage<T> readPage(JPQLQuery queryCount, JPQLQuery queryContent, Expression<T> expression, AbstractFiltroPaginado filtro) {
    Long total = queryCount.fetchCount();

    aplicarOrdernacao(queryContent, filtro);
    Pageable pageable = filtro.getPageable();
    List<T> content = total > pageable.getOffset()
      ? realizarPesquisaPaginada(queryContent, expression, pageable)
      : Collections.<T>emptyList();

    return new CustomPage(content, pageable, total);
  }

  protected <T> CustomPage<T> readPage(JPQLQuery query, Expression<T> expression, AbstractFiltroPaginado filtro) {
    // need to clone to have a second query, otherwise all items would be in the list
    Long total = query.fetchCount();

    Pageable pageable = filtro.getPageable();
    aplicarOrdernacao(query, filtro);
    List<T> content = total > pageable.getOffset()
      ? realizarPesquisaPaginada(query, expression, pageable)
      : Collections.<T>emptyList();

    return new CustomPage<T>(content, pageable, total);
  }

  private void aplicarOrdernacao(JPQLQuery query, AbstractFiltroPaginado filtro) {
    OrderSpecifier[] orderBy = new OrderSpecifier[] {};

    if (filtro.possuiOrdenacaoPorCampo()) {
      orderBy = ArrayUtils.add(orderBy, filtro.buildOrderByColumn());
    }

    for (Object order : filtro.orderByDefault()) {
      orderBy = ArrayUtils.add(orderBy, ((OrderSpecifier) order).nullsLast());
    }

    query.orderBy(orderBy);
  }

  private <T> List<T> realizarPesquisaPaginada(JPQLQuery query, Expression<T> expression, Pageable pageable) {
    JPQLQuery pagedQuery = getQuerydsl().applyPagination(pageable, query);
    return pagedQuery.select(expression).fetch();
  }
}
