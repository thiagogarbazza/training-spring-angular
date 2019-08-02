package com.github.thiagogarbazza.training.springangular.util.aspect;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@UtilityClass
public class AspectUtil {

  public static final String MSG_LOG_ENDING = "{0} Finalizando {1} com retorno \"{2}\" em {3}.";
  public static final String MSG_LOG_ERROR = "{0} Erro na execução {1} pelo motivo \"{2}\" depois de {3}.";
  public static final String MSG_LOG_START = "{0} Iniciando {1}";

  public static final String MSG_SYMBOL_H1 = "<h1>>>>>>>>";
  public static final String MSG_SYMBOL_H2 = "<h2>>>>>>>>";
  public static final String MSG_SYMBOL_H3 = "<!>>>>>>>>";
  public static final String MSG_SYMBOL_H4 = "<!>>>>>>>>";
  public static final String MSG_SYMBOL_H5 = "<!>>>>>>>>";
  public static final String MSG_SYMBOL_H6 = "<!>>>>>>>>";

  public static String toStringArgumentsBuild(Object value) {
    return value == null ? "null" : value.toString();
  }

  public static String toStringArgumentsBuild(JoinPoint joinPoint) {
    Object[] arguments = joinPoint.getArgs();

    if (ArrayUtils.isEmpty(arguments)) {
      return EMPTY;
    }

    StringBuilder response = new StringBuilder();
    for (final Object arg : arguments) {
      if (response.length() != 0) {
        response.append(", ");
      }

      response.append(toStringArgumentsBuild(arg));
    }

    return response.toString();
  }

  public static String toStringSignatureBuilder(JoinPoint joinPoint) {
    Signature signature = joinPoint.getSignature();
    String clazz = signature.getDeclaringType().getSimpleName();
    String method = signature.getName();

    return new StringBuilder()
      .append(clazz)
      .append(".")
      .append(method)
      .append("(")
      .append(toStringArgumentsBuild(joinPoint))
      .append(")")
      .toString();
  }
}
