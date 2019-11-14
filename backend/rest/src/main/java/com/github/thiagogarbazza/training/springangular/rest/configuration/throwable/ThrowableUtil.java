package com.github.thiagogarbazza.training.springangular.rest.configuration.throwable;

import lombok.experimental.UtilityClass;

import java.io.PrintWriter;
import java.io.StringWriter;

import static com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao.HOMOLOGACAO;
import static com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao.PRODUCAO;
import static com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao.getAmbienteExecucao;
import static java.util.Arrays.asList;

@UtilityClass
class ThrowableUtil {

  static String stackTraceToString(Throwable throwable) {
    if (!asList(PRODUCAO, HOMOLOGACAO).contains(getAmbienteExecucao())) {
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      throwable.printStackTrace(printWriter);
      return stringWriter.toString();
    } else {
      return null;
    }
  }
}
