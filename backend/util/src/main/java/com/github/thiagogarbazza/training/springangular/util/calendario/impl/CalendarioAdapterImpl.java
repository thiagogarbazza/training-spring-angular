package com.github.thiagogarbazza.training.springangular.util.calendario.impl;

import com.github.thiagogarbazza.training.springangular.util.calendario.CalendarioAdapter;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
class CalendarioAdapterImpl implements CalendarioAdapter {

  @Override
  public LocalDate calcularDataUtil(final LocalDate dataReferencia, final int diasUteis) {
    throw new NotImplementedException("Não implementado.");
  }

  @Override
  public boolean isDiaUtil(final LocalDate dataReferencia) {
    throw new NotImplementedException("Não implementado.");
  }
}
