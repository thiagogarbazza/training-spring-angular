package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import com.github.thiagogarbazza.training.springangular.util.security.Actions;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.Collection;

@Value
@Builder
@ToString
public class GrupoDocumentoForSearchingVO {

  private Actions actions;
  private DataToBuildForm dataToBuildForm;
  private FormData formData;
  private CustomPage<GrupoDocumentoVO4SearchResult> result;

  @Value
  @Builder
  @ToString
  public static class DataToBuildForm {

    private Collection<SituacaoGrupoDocumento> situacaoGrupoDocumentos;
  }

  @Value
  @Builder
  @ToString
  public static class FormData {

    private Collection<SituacaoGrupoDocumento> situacaoGrupoDocumentos;
    private String text;
  }
}
