package com.github.thiagogarbazza.training.springangular.util.calendario;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@UtilityClass
public class LocalDateUtil {

  public static final String DD_MM_YYYY = "dd/MM/yyyy";

  public static String localDateToString(LocalDate localDate) {
    return isNull(localDate) ? EMPTY : localDate.format(ofPattern(DD_MM_YYYY));
  }
}
