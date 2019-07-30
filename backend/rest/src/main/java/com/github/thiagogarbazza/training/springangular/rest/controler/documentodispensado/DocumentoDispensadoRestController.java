package com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.rest.comum.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource.DocumentoDispensadoResultadoPesquisaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/documento-dispensado")
class DocumentoDispensadoRestController {

  @Autowired
  private DocumentoDispensadoParaPesquisarService documentoDispensadoParaPesquisarService;
  @Autowired
  private DocumentoDispensadoPesquisarService documentoDispensadoPesquisarService;

  @RequestMapping(method = RequestMethod.GET, path = "/alterar")
  public String alterar() {
    return null;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/criar")
  public String criar() {
    return null;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/desativar")
  public String desativar() {
    return null;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/detalhar")
  public String detalhar() {
    return null;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/para-alterar")
  public String paraAlterar() {
    return null;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/para-criar")
  public String paraCriar() {
    return null;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/para-desativar")
  public String paraDesativar() {
    return null;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/para-pesquisar")
  public DocumentoDispensadoParaPesquisarResource paraPesquisar(DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return documentoDispensadoParaPesquisarService.paraPesquisar(filtroConsulta);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/pesquisar")
  public CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> pesquisar(DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return documentoDispensadoPesquisarService.pesquisar(filtroConsulta);
  }
}
