package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Collections.EMPTY_LIST;

public class IdentifiableUtil {

  public static <T extends Identifiable> Collection<T> findIdentifiablesByIds(Collection<T> identifiables, Collection<UUID> ids) {
    if (CollectionUtils.isEmpty(ids)) {
      return EMPTY_LIST;
    }

    return identifiables.stream()
      .filter(cliente -> ids.contains(cliente.getId()))
      .collect(Collectors.toList());
  }
}
