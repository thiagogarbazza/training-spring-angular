package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.Expression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Collection;
import java.util.Collections;

public abstract class CustomQueryDslRepositorySupport<E> extends QuerydslRepositorySupport {

  protected CustomQueryDslRepositorySupport(Class<E> domainClass) {
    super(domainClass);
  }

  protected <T> CustomPage<T> readPage(JPQLQuery queryCount, JPQLQuery queryContent, AbstractSearchFilter filtro, Expression<T> projection) {
    final long total = queryCount.fetchCount();
    final Collection<T> content = search(queryContent, filtro, total, projection);

    return new CustomPage<T>(content, total, filtro);
  }

  protected <T> CustomPage<T> readPage(final JPQLQuery query, final AbstractSearchFilter filtro, final Expression<T> projection) {
    final long total = query.fetchCount();
    final Collection<T> content = search(query, filtro, total, projection);

    return new CustomPage<T>(content, total, filtro);
  }

  private <T> Collection<T> search(final JPQLQuery query, final AbstractSearchFilter filtro, final long total, final Expression<T> projection) {
    query.orderBy(filtro.ordering());
    Pageable pageable = filtro.getPageable();

    return total > pageable.getOffset()
      ? getQuerydsl().applyPagination(pageable, query).select(projection).fetch()
      : Collections.emptyList();
  }
}
