package com.github.thiagogarbazza.training.springangular.rest.controler.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.DocumentoProcessado;
import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.DocumentoProcessadoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.DocumentoProcessadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.rest.comum.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentoprocessado.resource.DocumentoProcessadoResultadoPesquisaResource;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class DocumentoProcessadoPesquisarService {

  @Autowired
  private DocumentoProcessadoConsultaService documentoProcessadoConsultaService;
  //@Autowired
  //private MapperFacade mapper;

  public CustomPageResource<DocumentoProcessadoResultadoPesquisaResource> pesquisar(final DocumentoProcessadoFiltroConsulta filtroConsulta) {
    final CustomPage<DocumentoProcessado> documentoProcessados = documentoProcessadoConsultaService.pesquisarPaginando(filtroConsulta);

    //final CustomPageResource<DocumentoProcessadoResultadoPesquisaResource> customPageResource = mapper.map(documentoProcessados, CustomPageResource.class);
    //customPageResource.setContent(mapper.mapAsList(documentoProcessados.getContent(), DocumentoProcessadoResultadoPesquisaResource.class));

    final CustomPageResource<DocumentoProcessadoResultadoPesquisaResource>  customPageResource = new CustomPageResource<>();
    customPageResource.setTotalElements(12L);
    customPageResource.setContent(Arrays.asList(DocumentoProcessadoResultadoPesquisaResource.builder().codigoDocumento("DOC-01").build()));



    return customPageResource;
  }
}
