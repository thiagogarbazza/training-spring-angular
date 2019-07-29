package com.github.thiagogarbazza.training.springangular.batchcomum.processamento;

public class InterromperProcessadorException extends RuntimeException {

  public InterromperProcessadorException(Throwable e) {
    super(e);
  }

  public InterromperProcessadorException(String message, Throwable e) {
    super(message, e);
  }

  public InterromperProcessadorException(String message) {
    super(message);
  }
}
