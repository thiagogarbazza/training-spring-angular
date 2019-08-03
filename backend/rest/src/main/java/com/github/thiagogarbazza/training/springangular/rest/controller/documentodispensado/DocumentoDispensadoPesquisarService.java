package com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.rest.comum.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoResultadoPesquisaResource;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DocumentoDispensadoPesquisarService {

  @Autowired
  private DocumentoDispensadoConsultaService documentoDispensadoConsultaService;
  @Autowired
  private MapperFacade mapper;

  CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> pesquisar(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    final CustomPage<DocumentoDispensado> documentoDispensados = documentoDispensadoConsultaService.pesquisarPaginando(filtroConsulta);

    final CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> customPageResource = mapper.map(documentoDispensados, CustomPageResource.class);
    customPageResource.setContent(mapper.mapAsList(documentoDispensados.getContent(), DocumentoDispensadoResultadoPesquisaResource.class));

    return customPageResource;
  }
}
