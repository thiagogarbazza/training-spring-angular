package com.github.thiagogarbazza.training.springangular.util.calendario;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class PeriodoD4T {

  public static Periodo periodoAberto() {
    return new Periodo(LocalDate.of(2019, 1, 1));
  }

  public static Periodo periodoFechado() {
    return new Periodo(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 31));
  }
}
