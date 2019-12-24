package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
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
public class GrupoDocumentoForSearchingResource {

  private Actions actions;
  private DataToBuildForm dataToBuildForm;
  private FormData formData;
  private CustomPage<GrupoDocumentoVO4SearchResult> result;

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class Actions {

    private boolean doCreate;
    private boolean doReportExcel;
  }

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class DataToBuildForm {

    private Collection<SituacaoGrupoDocumento> situacaoGrupoDocumentos;
  }

  @Getter
  @Setter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
  public static class FormData {

    private Collection<SituacaoGrupoDocumento> situacaoGrupoDocumentos;
    private String text;
  }
}
