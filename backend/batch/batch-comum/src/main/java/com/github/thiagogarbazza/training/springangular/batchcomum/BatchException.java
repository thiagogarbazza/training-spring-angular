package com.github.thiagogarbazza.training.springangular.batchcomum;

public class BatchException extends RuntimeException {

  public BatchException(Throwable e) {
    super(e);
  }

  public BatchException(String message, Throwable e) {
    super(message, e);
  }

  public BatchException(String message) {
    super(message);
  }
}
