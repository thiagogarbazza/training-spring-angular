package com.github.thiagogarbazza.training.springangular.util;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectorsTest {

  @Test
  void verify() {
    final Collection<String> strings = asList("A", "B", "A", "C", "D", "D").stream()
      .collect(groupingBy(identity(), counting()))
      .entrySet()
      .stream()
      .filter(p -> p.getValue() > 1)
      .map(Map.Entry::getKey)
      .collect(Collectors.toList());

    assertEquals(asList("A", "D"), strings);
  }

  @Test
  void verify2() {
    // final Collection<String> strings = asList("A", "B", "A", "C", "D", "D").stream()
    //.collect(Collector.of(ArrayList::new, List::add, (a,b) -> { }));

    // assertEquals(asList("A", "D"), strings);
  }
}
