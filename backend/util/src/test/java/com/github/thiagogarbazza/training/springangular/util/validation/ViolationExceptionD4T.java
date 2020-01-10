package com.github.thiagogarbazza.training.springangular.util.validation;

import com.github.thiagogarbazza.violationbuilder.ViolationException;
import lombok.experimental.UtilityClass;

import static com.github.thiagogarbazza.training.springangular.util.validation.SimpleMessageD4T.simpleMessageError;
import static java.util.Collections.singleton;

@UtilityClass
public class ViolationExceptionD4T {

  public static ViolationException violationExceptionQualquer() {
    return new ViolationException("There was some violation.", singleton(simpleMessageError()));
  }
}
