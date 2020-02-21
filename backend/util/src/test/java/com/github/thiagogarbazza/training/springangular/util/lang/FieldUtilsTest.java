package com.github.thiagogarbazza.training.springangular.util.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FieldUtilsTest {

  @Test
  void verifyInheritanceClass() {
    assertTrue(FieldUtils.allFieldsIsEmpty(new ClassB(null, null)));
    assertFalse(FieldUtils.allFieldsIsEmpty(new ClassB("field-a", null)));
    assertFalse(FieldUtils.allFieldsIsEmpty(new ClassB(null, "field-b")));
    assertFalse(FieldUtils.allFieldsIsEmpty(new ClassB("field-a", "field-b")));
  }

  @Test
  void verifyInheritanceClassWithFinal() {
    assertTrue(FieldUtils.allFieldsIsEmpty(new ClassC(null, null, null)));
    assertFalse(FieldUtils.allFieldsIsEmpty(new ClassC("field-a", null, null)));
    assertFalse(FieldUtils.allFieldsIsEmpty(new ClassC(null, "field-b", null)));
    assertFalse(FieldUtils.allFieldsIsEmpty(new ClassC(null, null, "field-c")));
    assertFalse(FieldUtils.allFieldsIsEmpty(new ClassC("field-a", "field-b", "field-c")));
  }

  @Test
  void verifySimpleClass() {
    assertTrue(FieldUtils.allFieldsIsEmpty(new ClassA(null)));
    assertFalse(FieldUtils.allFieldsIsEmpty(new ClassA("field-a")));
  }

  static class ClassA {

    private static final int staticFieldA = 0;

    private String fieldA;

    ClassA(final String fieldA) {
      this.fieldA = fieldA;
    }
  }

  static class ClassB extends ClassA {

    private static final int staticFieldB = 1;
    private String fieldB;

    ClassB(final String fieldA, final String fieldB) {
      super(fieldA);
      this.fieldB = fieldB;
    }
  }

  static class ClassC extends ClassB {

    private static final int staticFieldC = 1;
    private final String fieldC;

    ClassC(final String fieldA, final String fieldB, final String fieldC) {
      super(fieldA, fieldB);
      this.fieldC = fieldC;
    }
  }
}
