package com.github.thiagogarbazza.training.springangular.util.lang;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BooleanUtil {

  private static final String NAO = "Não";
  private static final String SIM = "Sim";

  public static String booleanToString(boolean condicao) {
    return condicao ? SIM : NAO;
  }
}
