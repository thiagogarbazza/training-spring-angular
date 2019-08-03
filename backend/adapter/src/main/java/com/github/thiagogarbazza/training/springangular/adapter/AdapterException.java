package com.github.thiagogarbazza.training.springangular.adapter;

public class AdapterException extends RuntimeException {

  public AdapterException(final Throwable cause) {
    super(cause);
  }

  public AdapterException(final String mensagem, final Throwable cause) {
    super(mensagem, cause);
  }

  public AdapterException(final String mensagem) {
    super(mensagem);
  }
}
