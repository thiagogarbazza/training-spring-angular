package com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.rest.configuration.mapper.AssemblerMapper;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

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
    documentoDispensadoResultadoPesquisaResource.setCodigoCliente(documentoDispensado.getCliente().getCodigo());
    documentoDispensadoResultadoPesquisaResource.setCodigoDocumento(documentoDispensado.getDocumento().getCodigo());
    documentoDispensadoResultadoPesquisaResource.setCodigoGrupoDocumento(documentoDispensado.getDocumento().getGrupoDocumento().getCodigo());

    documentoDispensadoResultadoPesquisaResource.setAcoes(DocumentoDispensadoResultadoPesquisaResource.Acoes.builder()
      .podeAlterar(true)
      .podeDesativar(true)
      .podeDetalhar(true)
      .build());
  }
}
