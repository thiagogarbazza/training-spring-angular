package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import lombok.experimental.UtilityClass;
import org.springframework.data.querydsl.QPageRequest;

import java.util.Arrays;
import java.util.Collections;

@UtilityClass
public class CustomPageD4T {

  public static <T> CustomPage<T> newCustomPage(T... values) {
    return new CustomPage<T>(Arrays.asList(values), values.length, QPageRequest.of(0, 10));
  }

  public static <T> CustomPage<T> pageEmpty() {
    return new CustomPage<T>(Collections.emptyList(), 0, QPageRequest.of(0, 10));
  }
}
