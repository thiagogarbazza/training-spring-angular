package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdentifiableUtilTest {

  @Test
  void verificarFindIdentifiablesByIds() {
    SomeIdentifiable id1 = new SomeIdentifiable(UUID.randomUUID());
    SomeIdentifiable id2 = new SomeIdentifiable(UUID.randomUUID());

    Collection<SomeIdentifiable> someIdentifiables = IdentifiableUtil.findIdentifiablesByIds(Arrays.asList(id1, id2), Arrays.asList(id1.getId()));

    assertEquals(1, someIdentifiables.size());
    assertEquals(id1, IterableUtils.get(someIdentifiables, 0));
  }

  @Test
  void verificarFindIdentifiablesByIdsEmpty() {
    Collection<SomeIdentifiable> someIdentifiables = IdentifiableUtil.findIdentifiablesByIds(Collections.EMPTY_LIST, Collections.EMPTY_LIST);

    assertEquals(0, someIdentifiables.size());
  }

  @Test
  void verificarFindIdentifiablesEmptyByIds() {
    SomeIdentifiable id1 = new SomeIdentifiable(UUID.randomUUID());
    SomeIdentifiable id2 = new SomeIdentifiable(UUID.randomUUID());

    Collection<SomeIdentifiable> someIdentifiables = IdentifiableUtil.findIdentifiablesByIds(Arrays.asList(id1, id2), Collections.EMPTY_LIST);

    assertEquals(0, someIdentifiables.size());
  }

  static class SomeIdentifiable implements Identifiable {

    private final UUID id;

    SomeIdentifiable(final UUID id) {this.id = id;}

    @Override
    public UUID getId() {
      return id;
    }
  }
}
