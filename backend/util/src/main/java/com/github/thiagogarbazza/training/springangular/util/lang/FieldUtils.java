package com.github.thiagogarbazza.training.springangular.util.lang;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.ObjectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList;
import static org.apache.commons.lang3.reflect.FieldUtils.readField;

@UtilityClass
public class FieldUtils {

  public boolean allFieldsIsEmpty(Object o) {
    return getAllFieldsList(o.getClass()).stream() // Gets all fields of the given class and its parents
      .filter(f -> !Modifier.isStatic(f.getModifiers())) // Remove all static fields
      .map(f -> readValue(f, o)) // Map to values of fields
      .map(ObjectUtils::isEmpty) // Map to isEmpty or not of field
      .reduce(true, Boolean::logicalAnd); // Make sure all fields are empty.
  }

  static Object readValue(final Field f, final Object o) {
    try {
      return readField(f, o, true);
    } catch (IllegalAccessException e) {
      throw new RuntimeException("Erro ao verificar se o objeto está vazio", e);
    }
  }
}
