package com.github.thiagogarbazza.training.springangular.core.cliente;

import lombok.experimental.UtilityClass;

import static org.junit.jupiter.api.Assertions.*;

@UtilityClass
public class ClienteD4T {

  public static Cliente clienteThiagoGarbazza() {
    return Cliente.builder()
      .codigo("TG")
      .nome("Thiago Garbazza")
      .build();
  }

  public static Cliente clienteMickeyMouse() {
    return Cliente.builder()
      .codigo("MM")
      .nome("Mickey Mouse")
      .build();
  }
}
