package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import com.github.thiagogarbazza.training.springangular.util.security.Actions;
import lombok.Builder;
import lombok.Value;

import java.util.Collection;

@Value
@Builder
public class GrupoDocumentoForSearchingVO {

  private Actions actions;
  private DataToBuildForm dataToBuildForm;
  private FormData formData;
  private CustomPage<GrupoDocumentoVO4SearchResult> result;

  @Value
  @Builder
  public static class DataToBuildForm {

    private Collection<SituacaoGrupoDocumento> situacaoGrupoDocumentos;
  }

  @Value
  @Builder
  public static class FormData {

    private Collection<SituacaoGrupoDocumento> situacaoGrupoDocumentos;
    private String text;
  }
}
