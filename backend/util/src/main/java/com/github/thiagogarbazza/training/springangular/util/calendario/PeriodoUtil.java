package com.github.thiagogarbazza.training.springangular.util.calendario;

import lombok.experimental.UtilityClass;

import static com.github.thiagogarbazza.training.springangular.util.calendario.LocalDateUtil.localDateToString;
import static com.github.thiagogarbazza.training.springangular.util.lang.StringUtil.TRACO;
import static java.text.MessageFormat.format;
import static java.util.Objects.isNull;

@UtilityClass
public class PeriodoUtil {

  public static String periodoToString(Periodo periodo) {
    final String inicio = localDateToString(periodo.getInicio());
    final String fim = isNull(periodo.getFim()) ? TRACO : localDateToString(periodo.getFim());

    return format("{0} à {1}", inicio, fim);
  }
}
