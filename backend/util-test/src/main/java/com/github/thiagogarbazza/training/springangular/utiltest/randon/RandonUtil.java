package com.github.thiagogarbazza.training.springangular.utiltest.randon;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandonUtil {

  private static final Random RANDOM = new Random();

  public static int randonValue(int min, int max) {
    if (min < 0) { min = 0; }
    if (max < min) { max = min; }

    return max != min
      ? RANDOM.nextInt(max - min) + min
      : min;
  }
}
