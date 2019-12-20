package com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Select;
import com.github.thiagogarbazza.training.springangular.rest.controller.cliente.resource.ClienteParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documento.resource.DocumentoParaSelecaoResource;
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
public class DocumentoDispensadoParaCriarResource {

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
    private Collection<DocumentoParaSelecaoResource> documentos;
    private GrupoDocumentoVO4Select grupoDocumentos;
    private LocalDate vigenciaFim;
    private LocalDate vigenciaInicio;
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
    private Collection<GrupoDocumentoVO4Select> grupoDocumentos;
  }
}
