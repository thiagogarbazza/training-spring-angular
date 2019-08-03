package com.github.thiagogarbazza.training.springangular.util.calendario;

import java.time.LocalDate;

public interface CalendarioAdapter {

  LocalDate calcularDataUtil(LocalDate dataReferencia, int diasUteis);

  boolean isDiaUtil(LocalDate dataReferencia);
}
