package com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.rest.configuration.mapper.AssemblerMapper;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.SituacaoDocumentoDispensado.ATIVO;

@Component
class DocumentoDispensadoResultadoPesquisaMapper
  extends CustomMapper<DocumentoDispensado, DocumentoDispensadoResultadoPesquisaResource>
  implements AssemblerMapper {

  @Override
  public void configure(final MapperFactory mapperFactory) {
    mapperFactory.classMap(DocumentoDispensado.class, DocumentoDispensadoResultadoPesquisaResource.class)
      .customize(this)
      .byDefault()
      .register();
  }

  @Override
  public void mapAtoB(final DocumentoDispensado documentoDispensado,
    final DocumentoDispensadoResultadoPesquisaResource documentoDispensadoResultadoPesquisaResource, final MappingContext context) {
    documentoDispensadoResultadoPesquisaResource.setAcoes(DocumentoDispensadoResultadoPesquisaResource.Acoes.builder()
      .podeAlterar(ATIVO.equals(documentoDispensado.getSituacao()))
      .podeDesativar(ATIVO.equals(documentoDispensado.getSituacao()))
      .podeDetalhar(true)
      .build());
  }
}
