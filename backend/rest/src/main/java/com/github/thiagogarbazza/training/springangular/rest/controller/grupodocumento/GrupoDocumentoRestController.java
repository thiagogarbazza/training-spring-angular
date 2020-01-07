package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoCreateService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoDeleteService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoDetailService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoUpdateService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Create;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Detail;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Update;
import com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource.GrupoDocumentoForCreatingVO;
import com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource.GrupoDocumentoForSearchingVO;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("/grupo-documento")
class GrupoDocumentoRestController {

  @Autowired
  private GrupoDocumentoCreateService grupoDocumentoCreateService;
  @Autowired
  private GrupoDocumentoDeleteService grupoDocumentoDeleteService;
  @Autowired
  private GrupoDocumentoDetailService grupoDocumentoDetailService;
  @Autowired
  private GrupoDocumentoForSearchingService grupoDocumentoForSearchingService;
  @Autowired
  private GrupoDocumentoSearchService grupoDocumentoSearchService;
  @Autowired
  private GrupoDocumentoUpdateService grupoDocumentoUpdateService;
  @Autowired
  private GrupoDocumentoForCreatingService grupoDocumentoForCreatingService;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(code = HttpStatus.CREATED)
  public void create(@RequestBody final GrupoDocumentoVO4Create grupoDocumentoVO4Create) {
    grupoDocumentoCreateService.create(grupoDocumentoVO4Create);
  }

  @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
  public void delete(@PathVariable("id") UUID id) {
    grupoDocumentoDeleteService.delete(id);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  public GrupoDocumentoVO4Detail detail(@PathVariable("id") final UUID id) {
    return grupoDocumentoDetailService.detail(id);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/for-creating")
  public GrupoDocumentoForCreatingVO forCreating() {
    return grupoDocumentoForCreatingService.forCreating();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/for-searching")
  public GrupoDocumentoForSearchingVO forSearching(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return grupoDocumentoForSearchingService.forSearching(grupoDocumentoSearchFilter);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{id}/for-updating")
  public void forUpdating(@PathVariable("id") final UUID id) {

  }

  @RequestMapping(method = RequestMethod.GET, path = "/search")
  public CustomPage<GrupoDocumentoVO4SearchResult> search(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return grupoDocumentoSearchService.searchPaginating(grupoDocumentoSearchFilter);
  }

  @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
  public void update(@PathVariable("id") final UUID id, @RequestBody final GrupoDocumentoVO4Update grupoDocumentoVO4Update) {
    grupoDocumentoVO4Update.setId(id);
    grupoDocumentoUpdateService.update(grupoDocumentoVO4Update);
  }
}
