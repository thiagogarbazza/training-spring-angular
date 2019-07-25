package com.github.thiagogarbazza.training.springangular.rest.configuration.throwable;

import com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao;
import lombok.experimental.UtilityClass;

import java.io.PrintWriter;
import java.io.StringWriter;

import static com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao.HOMOLOGACAO;
import static com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao.PRODUCAO;
import static java.util.Arrays.asList;

@UtilityClass
class ThrowableUtil {

  static String stackTraceToString(Throwable throwable) {
    AmbienteExecucao ambienteExecucao = AmbienteExecucao.getInstance();
    if (!asList(PRODUCAO, HOMOLOGACAO).contains(ambienteExecucao)) {
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      throwable.printStackTrace(printWriter);
      return stringWriter.toString();
    } else {
      return null;
    }
  }
}
