package com.github.thiagogarbazza.training.springangular.report;

public class ReportException extends RuntimeException {

  public ReportException(final Throwable cause) {
    super(cause);
  }

  public ReportException(final String mensagem, final Throwable cause) {
    super(mensagem, cause);
  }

  public ReportException(final String mensagem) {
    super(mensagem);
  }
}
