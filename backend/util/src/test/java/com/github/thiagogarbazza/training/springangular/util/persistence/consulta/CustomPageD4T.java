package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Collections;

@UtilityClass
public class CustomPageD4T {

  public static <T> CustomPage<T> newCustomPage(T... values) {
    return new CustomPage<T>(Arrays.asList(values), values.length, SearchFilterD4T.newAbstractSearchFilter());
  }

  public static <T> CustomPage<T> pageEmpty() {
    return new CustomPage<T>(Collections.emptyList(), 0, SearchFilterD4T.newAbstractSearchFilter());
  }
}
