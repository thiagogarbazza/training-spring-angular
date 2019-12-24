package com.github.thiagogarbazza.training.springangular.util.logging;

import com.github.thiagogarbazza.violationbuilder.ViolationException;
import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

import static com.github.thiagogarbazza.training.springangular.util.aspect.AspectUtil.MSG_LOG_ENDING;
import static com.github.thiagogarbazza.training.springangular.util.aspect.AspectUtil.MSG_LOG_ERROR;
import static com.github.thiagogarbazza.training.springangular.util.aspect.AspectUtil.MSG_LOG_START;
import static com.github.thiagogarbazza.training.springangular.util.aspect.AspectUtil.MSG_SYMBOL_H6;
import static com.github.thiagogarbazza.training.springangular.util.aspect.AspectUtil.toStringSignatureBuilder;
import static java.text.MessageFormat.format;
import static java.time.Duration.between;
import static java.time.LocalDateTime.now;

@Aspect
@Component
@CommonsLog
public class LogObserverAdapter {

  @Around("execution(public * com.github.thiagogarbazza.training.springangular..*Adapter.*(..))")
  public Object logObserverService(final ProceedingJoinPoint joinPoint) throws Throwable {
    LocalDateTime start = now();

    beforePoint(joinPoint);
    Object resposta = executePoint(joinPoint, start);
    afterPoint(joinPoint, resposta, start);

    return resposta;
  }

  private void afterPoint(final ProceedingJoinPoint joinPoint, final Object resposta, final LocalDateTime start) {
    if (log.isDebugEnabled()) {
      final Duration duration = between(start, now());
      log.debug(format(MSG_LOG_ENDING, MSG_SYMBOL_H6, toStringSignatureBuilder(joinPoint), resposta, duration));
    }
  }

  private void beforePoint(final ProceedingJoinPoint joinPoint) {
    if (log.isDebugEnabled()) {
      log.debug(format(MSG_LOG_START, MSG_SYMBOL_H6, toStringSignatureBuilder(joinPoint)));
    }
  }

  private Object executePoint(final ProceedingJoinPoint joinPoint, final LocalDateTime start) throws Throwable {
    try {
      return joinPoint.proceed();
    } catch (ViolationException e) {
      throw e;
    } catch (Throwable throwable) {
      final Duration duration = between(start, now());
      log.error(format(MSG_LOG_ERROR, MSG_SYMBOL_H6, toStringSignatureBuilder(joinPoint), throwable.getMessage(), duration));

      throw throwable;
    }
  }
}
