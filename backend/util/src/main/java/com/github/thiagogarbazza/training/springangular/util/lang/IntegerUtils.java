package com.github.thiagogarbazza.training.springangular.util.lang;

import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class IntegerUtils {

  public static int defaultInteger(final Integer value, final int defaultValue) {
    return Objects.isNull(value) ? defaultValue : value;
  }

  public static int defaultPositiveInteger(final Integer value, final int defaultValue) {
    return Objects.isNull(value) || value < 0 ? defaultValue : value;
  }
}
