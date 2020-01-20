package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GrupoDocumentoForUpdatingVO {

  private FormData formData;

  @Value
  @Builder
  public static class FormData {

    private String codigo;
    private String nome;
  }
}
