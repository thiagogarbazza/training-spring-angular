package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@ToString
public class GrupoDocumentoForUpdatingVO {

  private FormData formData;

  @Value
  @Builder
  @ToString
  public static class FormData {

    private String codigo;
    private String nome;
  }
}
