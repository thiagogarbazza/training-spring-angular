package com.github.thiagogarbazza.training.springangular.util.persistence.enumeration;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EnumIdentifiableUtil {

  @SuppressWarnings("Unchecked")
  public static <E extends Enum, ID extends Object> E findById(final Class<E> enumClass, final ID id) {
    for (Enum e : enumClass.getEnumConstants()) {
      EnumIdentifiable castEnum = (EnumIdentifiable) e;
      if (castEnum.getId().equals(id)) {
        return (E) e;
      }
    }

    return null;
  }
}
