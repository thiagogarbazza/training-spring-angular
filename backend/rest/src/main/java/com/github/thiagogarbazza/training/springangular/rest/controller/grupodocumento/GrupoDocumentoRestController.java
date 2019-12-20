package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource.GrupoDocumentoParaPesquisarResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/grupo-documento")
public class GrupoDocumentoRestController {

  @Autowired
  private GrupoDocumentoParaPesquisarService grupoDocumentoParaPesquisarService;

  @RequestMapping(method = RequestMethod.GET, path = "/para-pesquisar")
  public GrupoDocumentoParaPesquisarResource paraPesquisar() {
    final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter = GrupoDocumentoSearchFilter.builder().build();

    return grupoDocumentoParaPesquisarService.paraPesquisar(grupoDocumentoSearchFilter);
  }
}
