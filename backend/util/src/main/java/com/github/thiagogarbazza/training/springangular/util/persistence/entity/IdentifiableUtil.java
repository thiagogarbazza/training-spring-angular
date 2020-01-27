package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@UtilityClass
public class IdentifiableUtil {

  public static <E extends Identifiable<T>, T> Collection<E> findAllIdentifiableById(final Collection<E> values, final Collection<T> ids) {
    if (CollectionUtils.isEmpty(values) || CollectionUtils.isEmpty(ids)) {
      return Collections.emptyList();
    }

    return values.stream()
      .filter(v -> ids.contains(v.getId()))
      .collect(Collectors.toList());
  }

  public static <E extends Identifiable<T>, T> E findIdentifiableById(final Collection<E> values, final T id) {
    if (CollectionUtils.isEmpty(values) || Objects.isNull(id)) {
      return null;
    }

    return values.stream()
      .filter(v -> id.equals(v.getId()))
      .findFirst()
      .orElse(null);
  }
}
