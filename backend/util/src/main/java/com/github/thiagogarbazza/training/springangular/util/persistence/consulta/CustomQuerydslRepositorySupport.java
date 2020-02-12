package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.Expression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Collection;
import java.util.Collections;

public abstract class CustomQuerydslRepositorySupport<E> extends QuerydslRepositorySupport {

  protected CustomQuerydslRepositorySupport(Class<E> domainClass) {
    super(domainClass);
  }

  protected <T> CustomPage<T> readPage(final JPQLQuery queryCount, final JPQLQuery queryContent, final AbstractSearchFilter filtro,
    final Expression<T> projection) {
    final Pageable pageable = PageableUtils.pageableBuild(filtro);
    final long total = queryCount.fetchCount();
    final Collection<T> content = readContentPage(queryContent, pageable, total, projection);

    return new CustomPage<T>(content, total, pageable);
  }

  protected <T> CustomPage<T> readPage(final JPQLQuery query, final AbstractSearchFilter filtro, final Expression<T> projection) {
    final Pageable pageable = PageableUtils.pageableBuild(filtro);
    final long total = query.fetchCount();
    final Collection<T> content = readContentPage(query, pageable, total, projection);

    return new CustomPage<T>(content, total, pageable);
  }

  private <T> Collection<T> readContentPage(final JPQLQuery query, final Pageable pageable, final long total, final Expression<T> projection) {
    return total > pageable.getOffset()
      ? getQuerydsl().applyPagination(pageable, query).select(projection).fetch()
      : Collections.emptyList();
  }
}
