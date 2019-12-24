package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource.GrupoDocumentoForSearchingResource;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
class GrupoDocumentoForSearchingService {

  @Autowired
  private GrupoDocumentoSearchService grupoDocumentoSearchService;

  GrupoDocumentoForSearchingResource forSearching(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return GrupoDocumentoForSearchingResource.builder()
      .actions(actionsBuild())
      .formData(formDataBuild(grupoDocumentoSearchFilter))
      .dataToBuildForm(dataToBuildFormBuild())
      .result(getResult(grupoDocumentoSearchFilter))
      .build();
  }

  private GrupoDocumentoForSearchingResource.Actions actionsBuild() {
    return GrupoDocumentoForSearchingResource.Actions.builder()
      .doCreate(true)
      .doReportExcel(true)
      .build();
  }

  private GrupoDocumentoForSearchingResource.DataToBuildForm dataToBuildFormBuild() {
    return GrupoDocumentoForSearchingResource.DataToBuildForm.builder()
      .situacaoGrupoDocumentos(asList(SituacaoGrupoDocumento.values()))
      .build();
  }

  private GrupoDocumentoForSearchingResource.FormData formDataBuild(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return GrupoDocumentoForSearchingResource.FormData.builder()
      .situacaoGrupoDocumentos(grupoDocumentoSearchFilter.getSituacoes())
      .build();
  }

  private CustomPage<GrupoDocumentoVO4SearchResult> getResult(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return grupoDocumentoSearchService.searchPaginating(grupoDocumentoSearchFilter);
  }
}
