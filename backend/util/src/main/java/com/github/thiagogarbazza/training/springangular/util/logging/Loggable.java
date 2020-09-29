package com.github.thiagogarbazza.training.springangular.util.logging;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {

  boolean duration() default true;

  String text() default StringUtils.EMPTY;

  Type type() default Type.NONE;

  enum Type {
    BLOCK_H1,
    H2,
    H3,
    H4,
    H5,
    H6,

    LINE_H1,
    NONE;
  }
}
