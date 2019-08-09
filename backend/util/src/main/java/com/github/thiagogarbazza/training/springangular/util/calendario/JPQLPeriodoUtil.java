package com.github.thiagogarbazza.training.springangular.util.calendario;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class JPQLPeriodoUtil {

  public static Predicate dataEstaContidaNoPeriodo(QPeriodo expression, LocalDate value) {
    if (value != null) {
      BooleanExpression inicio = expression.inicio.loe(value);
      BooleanExpression fim = expression.fim.isNull().or(expression.fim.goe(value));

      return inicio.and(fim);
    }

    return null;
  }

  public static Predicate dataEstaContidaNoPeriodo(QPeriodo expression, LocalDate inicio, LocalDate fim) {
    if (inicio != null) {
      if (fim == null) {
        return expression.inicio.loe(inicio);
      } else {
        return expression.inicio.between(inicio, fim).or(expression.fim.between(inicio, fim));
      }
    }

    return null;
  }
}
