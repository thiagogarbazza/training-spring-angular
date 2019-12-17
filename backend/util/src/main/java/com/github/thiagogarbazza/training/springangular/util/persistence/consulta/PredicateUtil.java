package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import lombok.experimental.UtilityClass;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@UtilityClass
public class PredicateUtil {

  public static Predicate equalsIfNotNull(StringExpression expression, String value) {
    if (isNotBlank(value)) {
      return expression.eq(value);
    }

    return null;
  }

  public static Predicate equalsIfNotNull(SimpleExpression expression, Object value) {
    if (value != null) {
      return expression.eq(value);
    }

    return null;
  }
}
