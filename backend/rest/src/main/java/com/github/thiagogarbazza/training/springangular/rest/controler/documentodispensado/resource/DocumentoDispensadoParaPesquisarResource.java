package com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.SituacaoDocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.rest.comum.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.cliente.resource.ClienteParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documento.resource.DocumentoParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.grupodocumento.resource.GrupoDocumentoParaSelecaoResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class DocumentoDispensadoParaPesquisarResource {

  private Acoes acoes;
  private DadosParaFormulario dadosParaFormulario;
  private ParametrosDePesquisa parametrosDePesquisa;
  private CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> resultadoPesquisa;

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class Acoes {

    private boolean podeGerarExcel;
    private boolean podeIncluir;
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
    Collection<SituacaoDocumentoDispensado> situacaoDocumentoDispensados;
  }

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class ParametrosDePesquisa {

    Collection<ClienteParaSelecaoResource> clientes;
    LocalDate dataBaseFim;
    LocalDate dataBaseInicio;
    Collection<DocumentoParaSelecaoResource> documentos;
    Collection<GrupoDocumentoParaSelecaoResource> grupodocumentos;
    Collection<SituacaoDocumentoDispensado> situacaoDocumentoDispensados;
  }
}
