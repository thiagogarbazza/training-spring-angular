package com.github.thiagogarbazza.training.springangular.rest.configuration.throwable;

import com.github.thiagogarbazza.violationbuilder.ViolationException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.text.MessageFormat.format;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

@Order(1)
@CommonsLog
@ControllerAdvice
class ControllerAdviceThrowableHandler {

  @Value("${app.message.error}")
  private String mensageError;
  /*
  @Order(1)
  @ResponseBody
  @ResponseStatus(UNAUTHORIZED)
  @ExceptionHandler(AccessDeniedException.class)
  public ThrowableResource accessDeniedException(AccessDeniedException throwable) {
    String mensagem = format("Acesso negado: ADE-{0}", getIdentificador());
    log.info(mensagem, throwable);

    return ThrowableResource.builder()
      .message(mensagem)
      .stackTrace(ThrowableUtil.stackTraceToString(throwable))
      .build();
  } */

  @Order(4)
  @ResponseBody
  @ResponseStatus(PRECONDITION_FAILED)
  @ExceptionHandler(IllegalArgumentException.class)
  public ThrowableResource illegalArgumentException(IllegalArgumentException throwable) {
    String mensagem = format(mensageError, "IAE", getIdentificador());
    log.error(mensagem, throwable);

    return ThrowableResource.builder()
      .message(mensagem)
      .stackTrace(ThrowableUtil.stackTraceToString(throwable))
      .build();
  }

  @Order(99)
  @ResponseBody
  @ResponseStatus(INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Throwable.class)
  public ThrowableResource throwable(Throwable throwable) {
    String mensagem = format(mensageError, "T", getIdentificador());
    log.error(mensagem, throwable);

    return ThrowableResource.builder()
      .message(mensagem)
      .stackTrace(ThrowableUtil.stackTraceToString(throwable))
      .build();
  }

  @Order(5)
  @ResponseBody
  @ResponseStatus(PRECONDITION_FAILED)
  @ExceptionHandler(ViolationException.class)
  public ThrowableResource violationException(ViolationException throwable) {
    log.trace(throwable.getMessage(), throwable);

    return ThrowableResource.builder()
      .message(throwable.getMessage())
      .stackTrace(ThrowableUtil.stackTraceToString(throwable))
      .violations(throwable.getViolations())
      .build();
  }

  private String getIdentificador() {
    return System.currentTimeMillis() + "";
  }
}
