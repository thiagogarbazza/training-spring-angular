package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import lombok.experimental.UtilityClass;

import java.util.Collection;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@UtilityClass
public class PredicateUtil {

  public static Predicate equalsIfNotNull(final StringExpression expression, final String value) {
    if (isNotBlank(value)) {
      return expression.eq(value);
    }

    return null;
  }

  public static <T> Predicate equalsIfNotNull(final SimpleExpression<T> expression, final T value) {
    if (value != null) {
      return expression.eq(value);
    }

    return null;
  }

  public static <T> Predicate inIfNotNull(final SimpleExpression<T> expression, final Collection<T> value) {
    if (value != null) {
      return expression.in(value);
    }

    return null;
  }
}
