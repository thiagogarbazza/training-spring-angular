package com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.SituacaoDocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.rest.comum.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.cliente.resource.ClienteParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documento.resource.DocumentoParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource.DocumentoDispensadoResultadoPesquisaResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.grupodocumento.resource.GrupoDocumentoParaSelecaoResource;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.Arrays.asList;

@Component
class DocumentoDispensadoParaPesquisarService {

  @Autowired
  private ClienteConsultaService clienteConsultaService;
  @Autowired
  private DocumentoConsultaService documentoConsultaService;
  @Autowired
  private DocumentoDispensadoPesquisarService documentoDispensadoPesquisarService;
  @Autowired
  private GrupoDocumentoConsultaService grupoDocumentoConsultaService;
  @Autowired
  private MapperFacade mapper;

  public DocumentoDispensadoParaPesquisarResource paraPesquisar(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    DocumentoDispensadoParaPesquisarResource.DadosParaFormulario dadosParaFormulario = dadosParaFormularioBuild();
    DocumentoDispensadoParaPesquisarResource.Acoes acoes = acoesBuild();
    DocumentoDispensadoParaPesquisarResource.ParametrosDePesquisa parametrosDePesquisa = parametrosDePesquisaBuild(filtroConsulta);
    CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> resultadoPesquisa = resultadoPesquisaBuild(filtroConsulta);

    return DocumentoDispensadoParaPesquisarResource.builder()
      .acoes(acoes)
      .dadosParaFormulario(dadosParaFormulario)
      .parametrosDePesquisa(parametrosDePesquisa)
      .resultadoPesquisa(resultadoPesquisa)
      .build();
  }

  private DocumentoDispensadoParaPesquisarResource.Acoes acoesBuild() {
    return DocumentoDispensadoParaPesquisarResource.Acoes.builder()
      .podeGerarExcel(true)
      .podeIncluir(true)
      .build();
  }

  private DocumentoDispensadoParaPesquisarResource.DadosParaFormulario dadosParaFormularioBuild() {
    final Collection<Cliente> clientes = clienteConsultaService.pesquisar();
    final Collection<Documento> documentos = documentoConsultaService.pesquisar(DocumentoFiltroConsulta.builder().build());
    final Collection<GrupoDocumento> grupodocumentos = grupoDocumentoConsultaService.pesquisar(GrupoDocumentoFiltroConsulta.builder().build());
    final Collection<SituacaoDocumentoDispensado> situacaoDocumentoDispensados = asList(SituacaoDocumentoDispensado.values());

    return DocumentoDispensadoParaPesquisarResource.DadosParaFormulario.builder()
      .clientes(mapper.mapAsList(clientes, ClienteParaSelecaoResource.class))
      .documentos(mapper.mapAsList(documentos, DocumentoParaSelecaoResource.class))
      .grupodocumentos(mapper.mapAsList(grupodocumentos, GrupoDocumentoParaSelecaoResource.class))
      .situacaoDocumentoDispensados(situacaoDocumentoDispensados)
      .build();
  }

  private DocumentoDispensadoParaPesquisarResource.ParametrosDePesquisa parametrosDePesquisaBuild(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return DocumentoDispensadoParaPesquisarResource.ParametrosDePesquisa.builder()
      .dataBaseInicio(filtroConsulta.getDataBaseInicio())
      .dataBaseFim(filtroConsulta.getDataBaseFim())
      .build();
  }

  private CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> resultadoPesquisaBuild(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return documentoDispensadoPesquisarService.pesquisar(filtroConsulta);
  }
}
