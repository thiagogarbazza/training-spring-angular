package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
class SearchFilterUtils {

  static int number(final Integer value, final int defaultValue) {
    return Objects.isNull(value) || value < 0
      ? defaultValue
      : value;
  }
}
