package com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PUBLIC;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PUBLIC)
@AllArgsConstructor(access = PUBLIC)
public class DocumentoDispensadoResultadoPesquisaResource {

  private Acoes acoes;
  private String codigoCliente;
  private String codigoDocumento;
  private UUID id;

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class Acoes {

    private boolean podeAlterar;
    private boolean podeDesativar;
    private boolean podeDetalhar;
  }
}
