package com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.rest.comum.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoParaAlterarResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoParaCriarResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoParaDesativarResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoResultadoPesquisaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("/documento-dispensado")
class DocumentoDispensadoRestController {

  @Autowired
  private DocumentoDispensadoParaAlterarService documentoDispensadoParaAlterarService;
  @Autowired
  private DocumentoDispensadoParaCriarService documentoDispensadoParaCriarService;
  @Autowired
  private DocumentoDispensadoParaPesquisarService documentoDispensadoParaPesquisarService;
  @Autowired
  private DocumentoDispensadoPesquisarService documentoDispensadoPesquisarService;
  @Autowired
  private DocumentoDispensadoParaDesativarService documentoDispensadoParaDesativarService;

  @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
  public void alterar(@PathVariable("id") UUID id) {

  }

  @RequestMapping(method = RequestMethod.POST, path = "/")
  @ResponseStatus(code = HttpStatus.CREATED)
  public void criar() {

  }

  @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
  public void deletar(@PathVariable("id") UUID id) {

  }

  @RequestMapping(method = RequestMethod.PUT, path = "/{id}/desativar")
  public void desativar(@PathVariable("id") UUID id) {

  }

  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  public String detalhar() {
    return null;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{id}/para-alterar")
  public DocumentoDispensadoParaAlterarResource paraAlterar(@PathVariable("id") UUID id) {
    return documentoDispensadoParaAlterarService.paraAlterar(id);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/para-criar")
  public DocumentoDispensadoParaCriarResource paraCriar(@RequestParam(value = "id", required = false) UUID id) {
    return documentoDispensadoParaCriarService.paraCriar(id);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{id}/para-desativar")
  public DocumentoDispensadoParaDesativarResource paraDesativar(@PathVariable("id") UUID id) {
    return documentoDispensadoParaDesativarService.paraDesativar(id);
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
