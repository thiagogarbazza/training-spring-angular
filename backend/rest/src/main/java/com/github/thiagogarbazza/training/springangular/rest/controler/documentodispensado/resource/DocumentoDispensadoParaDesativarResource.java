package com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource;

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
public class DocumentoDispensadoParaDesativarResource {

  private DadosFormulario dadosFormulario;
  private DadosParaFormulario dadosParaFormulario;

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class DadosFormulario {

    private ClienteParaSelecaoResource clientes;
    private LocalDate dataBaseFim;
    private LocalDate dataBaseInicio;
    private Collection<DocumentoParaSelecaoResource> documentos;
    private GrupoDocumentoParaSelecaoResource grupodocumentos;
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
    private Collection<GrupoDocumentoParaSelecaoResource> grupodocumentos;
  }
}
