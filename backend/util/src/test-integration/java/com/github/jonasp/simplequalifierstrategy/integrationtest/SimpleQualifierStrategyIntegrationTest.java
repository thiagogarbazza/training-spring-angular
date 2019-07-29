package com.github.jonasp.simplequalifierstrategy.integrationtest;

import com.github.thiagogarbazza.training.springangular.util.strategy.AbstractSimpleQualifierStrategyManager;
import com.github.thiagogarbazza.training.springangular.util.strategy.SimpleQualifierStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleQualifierStrategyIntegrationTest {

  private NumerictSimpleQualifierStrategyManager numerictSimpleQualifierStrategyManager;
  private StringSimpleQualifierStrategyManager stringSimpleQualifierStrategyManager;

  @BeforeEach
  void beforeAll() {
    numerictSimpleQualifierStrategyManager = new NumerictSimpleQualifierStrategyManager(asList(new NumericStrategyNegative(), new NumericStrategyPositive()));
    stringSimpleQualifierStrategyManager = new StringSimpleQualifierStrategyManager(singleton(new StringStrategyUnit()));
  }

  @Test
  void vefifyStrategy() {
    assertEquals(6, numerictSimpleQualifierStrategyManager.strategy(1).add1(5));
    assertEquals(4, numerictSimpleQualifierStrategyManager.strategy(-1).add1(5));
    assertEquals("bb", stringSimpleQualifierStrategyManager.strategy("a").duplicate("b"));
  }

  @Test
  void verifyTryDuplicationQualifier() {
    final UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
      NumerictSimpleQualifierStrategyManager numerictSimpleQualifierStrategyManager = new NumerictSimpleQualifierStrategyManager(
        asList(new NumericStrategyNegative(), new NumericStrategyNegative()));
    });

    assertEquals("Qualifier -1 is already associated with the com.github.jonasp.simplequalifierstrategy.integrationtest"
        + ".SimpleQualifierStrategyIntegrationTest$NumericStrategyNegative strategy.",
      exception.getMessage());
  }

  @Test
  void verifyUnregisteredStrategyForQualifier() {
    final UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class,
      () -> numerictSimpleQualifierStrategyManager.strategy(10));

    assertEquals("Strategy not registered for qualifier 10.", exception.getMessage());
  }

  interface NumericStrategy extends SimpleQualifierStrategy<Integer> {

    int add1(int i);
  }

  interface StringStrategy extends SimpleQualifierStrategy<String> {

    String duplicate(String a);
  }

  class NumericStrategyNegative implements NumericStrategy {

    @Override
    public int add1(final int o) {
      return o - 1;
    }

    @Override
    public Set<Integer> qualifiers() {
      return singleton(-1);
    }
  }

  class NumericStrategyPositive implements NumericStrategy {

    @Override
    public int add1(final int o) {
      return o + 1;
    }

    @Override
    public Set<Integer> qualifiers() {
      return singleton(1);
    }
  }

  class NumerictSimpleQualifierStrategyManager extends AbstractSimpleQualifierStrategyManager<Integer, NumericStrategy> {

    NumerictSimpleQualifierStrategyManager(Collection<NumericStrategy> estrategias) {
      super(estrategias);
    }
  }

  class StringSimpleQualifierStrategyManager extends AbstractSimpleQualifierStrategyManager<String, StringStrategy> {

    StringSimpleQualifierStrategyManager(Collection<StringStrategy> estrategias) {
      super(estrategias);
    }
  }

  class StringStrategyUnit implements StringStrategy {

    @Override
    public String duplicate(final String a) {
      return a + a;
    }

    @Override
    public Set<String> qualifiers() {
      return singleton("a");
    }
  }
}
