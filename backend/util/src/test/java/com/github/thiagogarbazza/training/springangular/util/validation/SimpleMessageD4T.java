package com.github.thiagogarbazza.training.springangular.util.validation;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.simplemessage.SimpleMessageType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SimpleMessageD4T {

  public static SimpleMessage simpleMessageError() {
    return new SimpleMessage(SimpleMessageType.ERROR, "error-key", "error-content");
  }

  public static SimpleMessage simpleMessageWarning() {
    return new SimpleMessage(SimpleMessageType.WARNING, "warning-key", "warning-content");
  }
}
