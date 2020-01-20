package com.github.thiagogarbazza.training.springangular.rest.configuration;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
class ControllerAdviceJsonConfig {

  @InitBinder
  public void initBinder(WebDataBinder webDataBinder) {
    webDataBinder.initDirectFieldAccess();
  }
}
