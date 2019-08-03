package com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource;

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
public class DocumentoDispensadoParaAlterarResource {

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
    private GrupoDocumentoParaSelecaoResource grupoDocumentos;
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
  }
}
