package com.github.thiagogarbazza.training.springangular.rest.controler;

import com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationInfoRestController {

  @Value("${app.build-info.timestamp}")
  private String buildInfoTimestamp;
  @Value("${app.build-info.version}")
  private String buildInfoVersion;

  @GetMapping(value = "/application-info")
  public ApplicationInfoResourceSupport applicationInfo() {
    return ApplicationInfoResourceSupport.builder()
      .acoes(ApplicationInfoResourceSupport.Acoes.builder().podeVerChangeLog(true).build())
      .ambiente(AmbienteExecucao.getInstance())
      .versao(this.buildInfoVersion)
      .versaoDataHora(this.buildInfoTimestamp)
      .build();
  }

  @Getter
  @Builder
  @ToString
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  static class ApplicationInfoResourceSupport {

    private final Acoes acoes;
    private final AmbienteExecucao ambiente;
    private final String versao;
    private final String versaoDataHora;

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class Acoes {

      private boolean podeVerChangeLog;
    }
  }
}
