package com.github.thiagogarbazza.training.springangular.adapter.calendario;

import lombok.Getter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.util.Arrays.asList;

@Service
@Primary
public class CalendarioAdapterStub implements CalendarioAdapter {

  private static final Collection<DayOfWeek> FINAL_SEMANA = asList(SUNDAY, SATURDAY);
  @Getter
  private final Collection<LocalDate> feriados = new ArrayList<>();

  @Override
  public LocalDate calcularDataUtil(final LocalDate dataReferencia, final int diasUteis) {
    return dataReferencia.plusDays(diasUteis);
  }

  @Override
  public boolean isDiaUtil(final LocalDate dataReferencia) {
    return !(FINAL_SEMANA.contains(dataReferencia.getDayOfWeek())
      || feriados.contains(dataReferencia));
  }

  public void clean() {
    feriados.clear();
  }
}
