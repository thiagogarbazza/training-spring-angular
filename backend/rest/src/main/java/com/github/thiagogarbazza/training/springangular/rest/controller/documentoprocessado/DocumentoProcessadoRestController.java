package com.github.thiagogarbazza.training.springangular.rest.controller.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.DocumentoProcessadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.rest.comum.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentoprocessado.resource.DocumentoProcessadoParaPesquisarResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentoprocessado.resource.DocumentoProcessadoResultadoPesquisaResource;
import com.github.thiagogarbazza.violationbuilder.ViolationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController()
@RequestMapping("/documento-processado")
class DocumentoProcessadoRestController {

  @Inject
  private DocumentoProcessadoParaPesquisarService documentoProcessadoParaPesquisarService;

  @Inject
  private DocumentoProcessadoPesquisarService documentoProcessadoPesquisarService;

  @RequestMapping(method = RequestMethod.GET, path = "/para-pesquisar")
  public DocumentoProcessadoParaPesquisarResource paraPesquisar(DocumentoProcessadoFiltroConsulta filtroConsulta) {
    return documentoProcessadoParaPesquisarService.paraPesquisar(filtroConsulta);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/pesquisar")
  public CustomPageResource<DocumentoProcessadoResultadoPesquisaResource> pesquisar(DocumentoProcessadoFiltroConsulta filtroConsulta) {
    new ViolationBuilder().error("key", "mensagem").build();

    return documentoProcessadoPesquisarService.pesquisar(filtroConsulta);
  }
}
