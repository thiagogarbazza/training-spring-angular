package com.github.thiagogarbazza.training.springangular.rest.controller.documentoprocessado.resource;

import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.SituacaoDocumentoProcessado;
import com.github.thiagogarbazza.training.springangular.rest.comum.consulta.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.cliente.resource.ClienteParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documento.resource.DocumentoParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource.GrupoDocumentoParaSelecaoResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class DocumentoProcessadoParaPesquisarResource {

  private Acoes acoes;
  private DadosParaFormulario dadosParaFormulario;
  private ParametrosDePesquisa parametrosDePesquisa;
  private CustomPageResource<DocumentoProcessadoResultadoPesquisaResource> resultadoPesquisa;

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class Acoes {

    private boolean podeGerarExcel;
  }

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class DadosParaFormulario {

    Collection<ClienteParaSelecaoResource> clientes;
    Collection<DocumentoParaSelecaoResource> documentos;
    Collection<GrupoDocumentoParaSelecaoResource> grupodocumentos;
    Collection<SituacaoDocumentoProcessado> situacaoDocumentoProcessados;
  }

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class ParametrosDePesquisa {

    Collection<ClienteParaSelecaoResource> clientes;
  }
}
