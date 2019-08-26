package com.github.thiagogarbazza.training.springangular.adapter.mail;

public enum EmailPriority {

  HIGHEST(1),
  HIGH(2),
  NORMAL(3),
  LOW(4),
  LOWEST(5);

  private final int code;

  EmailPriority(final int code) {
    this.code = code;
  }
}
