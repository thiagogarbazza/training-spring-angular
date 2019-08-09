package com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.SituacaoDocumentoDispensado;
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
  private DadosFormulario dadosFormulario;
  private DadosParaFormulario dadosParaFormulario;
  private CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> resultadoPesquisa;

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class Acoes {

    private boolean podeCriar;
    private boolean podeGerarRelatorioExcel;
  }

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class DadosFormulario {

    private Collection<ClienteParaSelecaoResource> clientes;
    private LocalDate vigenciaFim;
    private LocalDate vigenciaInicio;
    private Collection<DocumentoParaSelecaoResource> documentos;
    private Collection<GrupoDocumentoParaSelecaoResource> grupoDocumentos;
    private Collection<SituacaoDocumentoDispensado> situacaoDocumentoDispensados;
  }

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class DadosParaFormulario {

    private Collection<ClienteParaSelecaoResource> clientes;
    private Collection<DocumentoParaSelecaoResource> documentos;
    private Collection<GrupoDocumentoParaSelecaoResource> grupoDocumentos;
    private Collection<SituacaoDocumentoDispensado> situacaoDocumentoDispensados;
  }
}
