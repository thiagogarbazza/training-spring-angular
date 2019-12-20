package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource.GrupoDocumentoParaPesquisarResource;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
class GrupoDocumentoParaPesquisarService {

  @Autowired
  private GrupoDocumentoSearchService grupoDocumentoSearchService;

  GrupoDocumentoParaPesquisarResource paraPesquisar(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return GrupoDocumentoParaPesquisarResource.builder()
      .actions(actionsBuild())
      .formData(formDataBuild())
      .dataToBuildForm(dataToBuildFormBuild())
      .result(getResult(grupoDocumentoSearchFilter))
      .build();
  }

  private GrupoDocumentoParaPesquisarResource.Actions actionsBuild() {
    return GrupoDocumentoParaPesquisarResource.Actions.builder()
      .doCreate(true)
      .doReportExcel(true)
      .build();
  }

  private GrupoDocumentoParaPesquisarResource.DataToBuildForm dataToBuildFormBuild() {
    return GrupoDocumentoParaPesquisarResource.DataToBuildForm.builder()
      .situacaoGrupoDocumentos(asList(SituacaoGrupoDocumento.values()))
      .build();
  }

  private GrupoDocumentoParaPesquisarResource.FormData formDataBuild() {
    return GrupoDocumentoParaPesquisarResource.FormData.builder()
      .build();
  }

  private CustomPage<GrupoDocumentoVO4SearchResult> getResult(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return grupoDocumentoSearchService.searchPaginating(grupoDocumentoSearchFilter);
  }
}
