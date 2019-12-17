package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.Expression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Collections;
import java.util.List;

public abstract class CustomQueryDslRepositorySupport<E> extends QuerydslRepositorySupport {

  protected CustomQueryDslRepositorySupport(Class<E> domainClass) {
    super(domainClass);
  }

  protected <T> CustomPage<T> readPage(JPQLQuery queryCount, JPQLQuery queryContent, Expression<T> expression, AbstractSearchFilter filtro) {
    Long total = queryCount.fetchCount();

    queryContent.orderBy(filtro.ordering());
    Pageable pageable = filtro.getPageable();
    List<T> content = total > pageable.getOffset()
      ? realizarPesquisaPaginada(queryContent, expression, pageable)
      : Collections.<T>emptyList();

    return new CustomPage<T>(content, pageable, total);
  }

  protected <T> CustomPage<T> readPage(JPQLQuery query, Expression<T> expression, AbstractSearchFilter filtro) {
    // need to clone to have a second query, otherwise all items would be in the list
    Long total = query.fetchCount();

    Pageable pageable = filtro.getPageable();
    query.orderBy(filtro.ordering());

    List<T> content = total > pageable.getOffset()
      ? realizarPesquisaPaginada(query, expression, pageable)
      : Collections.<T>emptyList();

    return new CustomPage<T>(content, pageable, total);
  }

  private <T> List<T> realizarPesquisaPaginada(JPQLQuery query, Expression<T> expression, Pageable pageable) {
    JPQLQuery pagedQuery = getQuerydsl().applyPagination(pageable, query);
    return pagedQuery.select(expression).fetch();
  }
}
