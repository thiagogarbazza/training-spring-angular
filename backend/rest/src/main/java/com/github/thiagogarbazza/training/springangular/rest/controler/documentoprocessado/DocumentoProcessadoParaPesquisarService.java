package com.github.thiagogarbazza.training.springangular.rest.controler.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.DocumentoProcessadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.SituacaoDocumentoProcessado;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.rest.comum.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.cliente.resource.ClienteParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documento.resource.DocumentoParaSelecaoResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentoprocessado.resource.DocumentoProcessadoParaPesquisarResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentoprocessado.resource.DocumentoProcessadoResultadoPesquisaResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.grupodocumento.resource.GrupoDocumentoParaSelecaoResource;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.Arrays.asList;

@Component
class DocumentoProcessadoParaPesquisarService {

  @Autowired
  private ClienteConsultaService clienteConsultaService;
  @Autowired
  private DocumentoConsultaService documentoConsultaService;
  @Autowired
  private DocumentoProcessadoPesquisarService documentoProcessadoPesquisarService;
  @Autowired
  private GrupoDocumentoConsultaService grupoDocumentoConsultaService;
  @Autowired
  private MapperFacade mapper;

  public DocumentoProcessadoParaPesquisarResource paraPesquisar(final DocumentoProcessadoFiltroConsulta filtroConsulta) {
    DocumentoProcessadoParaPesquisarResource.DadosParaFormulario dadosParaFormulario = dadosParaFormularioBuild();
    DocumentoProcessadoParaPesquisarResource.Acoes acoes = acoesBuild();
    DocumentoProcessadoParaPesquisarResource.ParametrosDePesquisa parametrosDePesquisa = parametrosDePesquisaBuild(filtroConsulta);
    CustomPageResource<DocumentoProcessadoResultadoPesquisaResource> resultadoPesquisa = resultadoPesquisaBuild(filtroConsulta);

    return DocumentoProcessadoParaPesquisarResource.builder()
      .acoes(acoes)
      .dadosParaFormulario(dadosParaFormulario)
      .parametrosDePesquisa(parametrosDePesquisa)
      .resultadoPesquisa(resultadoPesquisa)
      .build();
  }

  private DocumentoProcessadoParaPesquisarResource.Acoes acoesBuild() {
    return DocumentoProcessadoParaPesquisarResource.Acoes.builder()
      .podeGerarExcel(true)
      .build();
  }

  private DocumentoProcessadoParaPesquisarResource.DadosParaFormulario dadosParaFormularioBuild() {
    final Collection<Cliente> clientes = clienteConsultaService.pesquisar();
    final Collection<Documento> documentos = documentoConsultaService.pesquisar(DocumentoFiltroConsulta.builder().build());
    final Collection<GrupoDocumento> grupodocumentos = grupoDocumentoConsultaService.pesquisar(GrupoDocumentoFiltroConsulta.builder().build());
    final Collection<SituacaoDocumentoProcessado> situacaoDocumentoProcessados = asList(SituacaoDocumentoProcessado.values());

    return DocumentoProcessadoParaPesquisarResource.DadosParaFormulario.builder()
      .clientes(mapper.mapAsList(clientes, ClienteParaSelecaoResource.class))
      .documentos(mapper.mapAsList(documentos, DocumentoParaSelecaoResource.class))
      .grupodocumentos(mapper.mapAsList(grupodocumentos, GrupoDocumentoParaSelecaoResource.class))
      .situacaoDocumentoProcessados(situacaoDocumentoProcessados)
      .build();
  }

  private DocumentoProcessadoParaPesquisarResource.ParametrosDePesquisa parametrosDePesquisaBuild(final DocumentoProcessadoFiltroConsulta filtroConsulta) {
    return DocumentoProcessadoParaPesquisarResource.ParametrosDePesquisa.builder()
      .build();
  }

  private CustomPageResource<DocumentoProcessadoResultadoPesquisaResource> resultadoPesquisaBuild(final DocumentoProcessadoFiltroConsulta filtroConsulta) {
    return documentoProcessadoPesquisarService.pesquisar(filtroConsulta);
  }
}
