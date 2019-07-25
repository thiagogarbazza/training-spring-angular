package com.github.thiagogarbazza.training.springangular.util.ambiente;

import lombok.Getter;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

public enum AmbienteExecucao {
  LOCAL("local", "Local"),
  DESENVOLVIMENTO("dsen", "Desenvolvimento"),
  HOMOLOGACAO("homo", "Homologação"),
  PRODUCAO("prod", "Produção"),
  DESCONHECIDO(null, "Desconhecido");

  @Getter
  private String descricao;
  private String identificacao;

  AmbienteExecucao(final String identificacao, String descricao) {
    this.identificacao = identificacao;
    this.descricao = descricao;
  }

  public static boolean ehAmbienteCooporativoDiferenteProducao() {
    AmbienteExecucao instance = getInstance();
    return instance.equals(DESENVOLVIMENTO) || instance.equals(HOMOLOGACAO);
  }

  public static AmbienteExecucao getInstance() {
    final String env = trimToEmpty(System.getenv().get("ENV_NAME"));

    for (AmbienteExecucao ae : values()) {
      if (env.equals(ae.identificacao)) {
        return ae;
      }
    }
    
    return DESCONHECIDO;
  }
}
