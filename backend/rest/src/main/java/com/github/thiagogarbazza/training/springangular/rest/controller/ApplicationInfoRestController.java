package com.github.thiagogarbazza.training.springangular.rest.controller;

import com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao.getAmbienteExecucao;
import static lombok.AccessLevel.PRIVATE;

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
      .ambiente(getAmbienteExecucao())
      .versao(this.buildInfoVersion)
      .versaoDataHora(this.buildInfoTimestamp)
      .build();
  }

  @lombok.Value
  @Builder
  @AllArgsConstructor(access = PRIVATE)
  @NoArgsConstructor(force = true, access = PRIVATE)
  static class ApplicationInfoResourceSupport {

    private final Acoes acoes;
    private final AmbienteExecucao ambiente;
    private final String versao;
    private final String versaoDataHora;

    @lombok.Value
    @Builder
    @AllArgsConstructor(access = PRIVATE)
    @NoArgsConstructor(force = true, access = PRIVATE)
    static class Acoes {

      private boolean podeVerChangeLog;
    }
  }
}
