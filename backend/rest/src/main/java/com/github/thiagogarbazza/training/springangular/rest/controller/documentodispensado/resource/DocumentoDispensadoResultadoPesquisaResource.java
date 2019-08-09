package com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.SituacaoDocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.rest.controller.cliente.resource.ClienteParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documento.resource.DocumentoParaSelecaoResource;
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
  private ClienteParaSelecaoResource cliente;
  private DocumentoParaSelecaoResource documento;
  private SituacaoDocumentoDispensado situacao;
  private UUID id;
  private String vigencia;

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
