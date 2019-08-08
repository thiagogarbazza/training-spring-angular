package com.github.thiagogarbazza.training.springangular.rest;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
class RestExecucaoLocal {

  private static final int PORT = 9090;
  private static final String contextPath = "";

  public static void main(String[] args) {
    new EmbeddedJetty(PORT).run();
  }
}
