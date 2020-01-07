package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource.GrupoDocumentoForSearchingVO;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import com.github.thiagogarbazza.training.springangular.util.security.Action;
import com.github.thiagogarbazza.training.springangular.util.security.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
class GrupoDocumentoForSearchingService {

  @Autowired
  private GrupoDocumentoSearchService grupoDocumentoSearchService;

  GrupoDocumentoForSearchingVO forSearching(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return GrupoDocumentoForSearchingVO.builder()
      .actions(actionsBuild())
      .formData(formDataBuild(grupoDocumentoSearchFilter))
      .dataToBuildForm(dataToBuildFormBuild())
      .result(getResult(grupoDocumentoSearchFilter))
      .build();
  }

  private Actions actionsBuild() {
    final Actions actions = new Actions();

    actions.put(Actions.ACTION_CAN_CREATE, Action.builder()
      .doAction(true)
      .name("Novo grupo de documento")
      .tooltip("Clique aqui para criar um novo grupo de documento")
      .build());
    actions.put(Actions.ACTION_CAN_REPORT_EXCEL, Action.builder()
      .doAction(true)
      .name("Relatório excel grupo de documento")
      .tooltip("Clique aqui para gerar de grupo de documento")
      .build());

    return actions;
  }

  private GrupoDocumentoForSearchingVO.DataToBuildForm dataToBuildFormBuild() {
    return GrupoDocumentoForSearchingVO.DataToBuildForm.builder()
      .situacaoGrupoDocumentos(asList(SituacaoGrupoDocumento.values()))
      .build();
  }

  private GrupoDocumentoForSearchingVO.FormData formDataBuild(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return GrupoDocumentoForSearchingVO.FormData.builder()
      .situacaoGrupoDocumentos(grupoDocumentoSearchFilter.getSituacoes())
      .build();
  }

  private CustomPage<GrupoDocumentoVO4SearchResult> getResult(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return grupoDocumentoSearchService.searchPaginating(grupoDocumentoSearchFilter);
  }
}
