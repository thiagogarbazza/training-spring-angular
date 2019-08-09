package com.github.thiagogarbazza.training.springangular.util.calendario;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.github.thiagogarbazza.training.springangular.util.calendario.PeriodoUtil.periodoToString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PeriodoUtilTest {

  @Nested
  class PeriodoToString {

    @Test
    void verificarPeriodoAberto() {
      final Periodo periodo = new Periodo(LocalDate.of(2019, 12, 31));

      assertEquals("31/12/2019 à -", periodoToString(periodo));
    }

    @Test
    void verificarPeriodoFechado() {
      final Periodo periodo = new Periodo(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 12, 31));

      assertEquals("01/01/2019 à 31/12/2019", periodoToString(periodo));
    }
  }
}
