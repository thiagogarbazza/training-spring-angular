package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class IdentifiableUtilTest {

  private static final SomeIdentifiable IDENTIFIABLE_1 = new SomeIdentifiable(UUID.randomUUID());
  private static final Collection<UUID> IDENTIFIABLES = Collections.singletonList(IDENTIFIABLE_1.getId());
  private static final SomeIdentifiable IDENTIFIABLE_2 = new SomeIdentifiable(UUID.randomUUID());
  private static final Collection<SomeIdentifiable> VALUES = Arrays.asList(IDENTIFIABLE_1, IDENTIFIABLE_2);

  @Nested
  class MethodFindAllIdentifiableById {

    @Test
    void veify00() {
      Collection<SomeIdentifiable> someIdentifiables = IdentifiableUtil.findAllIdentifiableById(VALUES, IDENTIFIABLES);

      assertEquals(1, someIdentifiables.size());
      assertEquals(IDENTIFIABLE_1, IterableUtils.get(someIdentifiables, 0));
    }

    @Test
    void veify01() {
      Collection<SomeIdentifiable> someIdentifiables = IdentifiableUtil.findAllIdentifiableById(VALUES, Collections.emptyList());

      assertEquals(0, someIdentifiables.size());
    }

    @Test
    void veify02() {
      Collection<SomeIdentifiable> someIdentifiables = IdentifiableUtil.findAllIdentifiableById(Collections.emptyList(), IDENTIFIABLES);

      assertEquals(0, someIdentifiables.size());
    }

    @Test
    void veify03() {
      Collection<SomeIdentifiable> someIdentifiables = IdentifiableUtil.findAllIdentifiableById(Collections.emptyList(), Collections.emptyList());

      assertEquals(0, someIdentifiables.size());
    }
  }

  @Nested
  class MethodFindIdentifiableById {

    @Test
    void veify00() {
      SomeIdentifiable someIdentifiable = IdentifiableUtil.findIdentifiableById(VALUES, IDENTIFIABLE_1.getId());

      assertNotNull(someIdentifiable);
      assertEquals(IDENTIFIABLE_1, someIdentifiable);
    }

    @Test
    void veify01() {
      SomeIdentifiable someIdentifiable = IdentifiableUtil.findIdentifiableById(VALUES, UUID.randomUUID());

      assertNull(someIdentifiable);
    }

    @Test
    void veify02() {
      SomeIdentifiable someIdentifiable = IdentifiableUtil.findIdentifiableById(VALUES, null);

      assertNull(someIdentifiable);
    }

    @Test
    void veify03() {
      SomeIdentifiable someIdentifiable = IdentifiableUtil.findIdentifiableById(Collections.emptyList(), UUID.randomUUID());

      assertNull(someIdentifiable);
    }

    @Test
    void veify04() {
      SomeIdentifiable someIdentifiable = IdentifiableUtil.findIdentifiableById(Collections.emptyList(), null);

      assertNull(someIdentifiable);
    }
  }

  static class SomeIdentifiable implements Identifiable<UUID> {

    private final UUID id;

    SomeIdentifiable(final UUID id) {this.id = id;}

    @Override
    public UUID getId() {
      return id;
    }
  }
}
