package com.github.thiagogarbazza.training.springangular.rest.controler;

import com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppInfoRestController {

  @Value("${app.versao}")
  private String versao;
  @Value("${app.versao.data-hora}")
  private String versaoDataHora;

  @GetMapping(value = "/app-info")
  public ApplicationInfoResourceSupport applicationInfo() {
    return ApplicationInfoResourceSupport.builder()
      .ambiente(AmbienteExecucao.getInstance())
      .podeVerChangeLog(true)
      .versao(this.versao)
      .versaoDataHora(this.versaoDataHora)
      .build();
  }

  @Getter
  @Builder
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  static class ApplicationInfoResourceSupport {

    private AmbienteExecucao ambiente;
    private boolean podeVerChangeLog;
    private String versao;
    private String versaoDataHora;
  }
}
