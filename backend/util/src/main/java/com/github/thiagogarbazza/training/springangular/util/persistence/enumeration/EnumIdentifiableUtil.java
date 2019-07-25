package com.github.thiagogarbazza.training.springangular.util.persistence.enumeration;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EnumIdentifiableUtil {

  @SuppressWarnings("Unchecked")
  public static <T extends Object, C extends Enum> C findById(final Class<C> enumClass, final int id) {
    for (Enum e : enumClass.getEnumConstants()) {
      EnumIdentifiable castEnum = (EnumIdentifiable) e;
      if (castEnum.getId() == id) {
        return (C) e;
      }
    }

    return null;
  }
}
