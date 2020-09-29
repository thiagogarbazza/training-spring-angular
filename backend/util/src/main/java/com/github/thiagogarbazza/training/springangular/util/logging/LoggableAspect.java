package com.github.thiagogarbazza.training.springangular.util.logging;

import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

import static com.github.thiagogarbazza.training.springangular.util.aspect.AspectUtil.MSG_LOG_ENDING;
import static com.github.thiagogarbazza.training.springangular.util.aspect.AspectUtil.MSG_SYMBOL_H6;
import static com.github.thiagogarbazza.training.springangular.util.aspect.AspectUtil.toStringSignatureBuilder;
import static java.text.MessageFormat.format;

@Aspect
@Component
@CommonsLog
class LoggableAspect {

  private static final String PROPERTIE_FILE = "loggable.properties";

  @Before(value = "@annotation(loggable)", argNames = "loggable")
  void before(final JoinPoint joinPoint, Loggable loggable) {
    log.info("Qual type está informado: " + loggable.type());
    //log.debug(format(MSG_LOG_ENDING, MSG_SYMBOL_H6, toStringSignatureBuilder(joinPoint), resposta, duration));
  }
}
