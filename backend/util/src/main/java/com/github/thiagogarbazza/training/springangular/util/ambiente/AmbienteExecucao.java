package com.github.thiagogarbazza.training.springangular.util.ambiente;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

@Getter
public enum AmbienteExecucao implements EnumIdentifiableWithDescription {

  DESENVOLVIMENTO("dsen", "Desenvolvimento"),
  HOMOLOGACAO("homo", "Homologação"),
  PRODUCAO("prod", "Produção"),
  DESCONHECIDO(null, "Desconhecido");

  private String description;
  private String id;

  AmbienteExecucao(final String id, String description) {
    this.id = id;
    this.description = description;
  }

  public static AmbienteExecucao getAmbienteExecucao() {
    final String env = trimToEmpty(System.getenv().get("ENV_ID"));

    for (AmbienteExecucao ae : values()) {
      if (env.equals(ae.id)) {
        return ae;
      }
    }

    return DESCONHECIDO;
  }
}
