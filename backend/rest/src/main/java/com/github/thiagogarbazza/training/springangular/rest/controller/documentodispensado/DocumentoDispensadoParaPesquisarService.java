package com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.SituacaoDocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Select;
import com.github.thiagogarbazza.training.springangular.rest.comum.consulta.CustomPageResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource.Acoes;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource.DadosFormulario;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource.DadosParaFormulario;
import com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado.resource.DocumentoDispensadoResultadoPesquisaResource;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.util.persistence.entity.IdentifiableUtil.findAllIdentifiableById;
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
  private GrupoDocumentoSearchService grupoDocumentoConsultaService;
  @Autowired
  private MapperFacade mapper;

  DocumentoDispensadoParaPesquisarResource paraPesquisar(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    DadosParaFormulario dadosParaFormulario = dadosParaFormularioBuild();
    Acoes acoes = acoesBuild();
    DadosFormulario dadosFormulario = dadosFormularioBuild(dadosParaFormulario, filtroConsulta);
    CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> resultadoPesquisa = resultadoPesquisaBuild(filtroConsulta);

    return DocumentoDispensadoParaPesquisarResource.builder()
      .acoes(acoes)
      .dadosParaFormulario(dadosParaFormulario)
      .dadosFormulario(dadosFormulario)
      //.resultadoPesquisa(resultadoPesquisa)
      .build();
  }

  private Acoes acoesBuild() {
    return Acoes.builder()
      .podeCriar(true)
      .podeGerarRelatorioExcel(true)
      .build();
  }

  private DadosFormulario dadosFormularioBuild(final DadosParaFormulario dadosParaFormulario, final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return DadosFormulario.builder()
      .clientes(findAllIdentifiableById(dadosParaFormulario.getClientes(), filtroConsulta.getClientes()))
      .documentos(findAllIdentifiableById(dadosParaFormulario.getDocumentos(), filtroConsulta.getDocumentos()))
      .grupoDocumentos(findAllIdentifiableById(dadosParaFormulario.getGrupoDocumentos(), filtroConsulta.getGrupoDocumentos()))
      .vigenciaInicio(filtroConsulta.getVigenciaInicio())
      .vigenciaFim(filtroConsulta.getVigenciaFim())
      .situacaoDocumentoDispensados(filtroConsulta.getSituacoes())
      .build();
  }

  private DadosParaFormulario dadosParaFormularioBuild() {
    final Collection<Cliente> clientes = clienteConsultaService.pesquisar();
    final Collection<Documento> documentos = documentoConsultaService.pesquisar(DocumentoFiltroConsulta.builder().build());
    final Collection<GrupoDocumentoVO4Select> grupodocumentos = grupoDocumentoConsultaService.search4Select(GrupoDocumentoSearchFilter.builder().build());
    final Collection<SituacaoDocumentoDispensado> situacaoDocumentoDispensados = asList(SituacaoDocumentoDispensado.values());

    return DadosParaFormulario.builder()
     // .clientes(mapper.mapAsList(clientes, ClienteParaSelecaoResource.class))
      //.documentos(mapper.mapAsList(documentos, DocumentoParaSelecaoResource.class))
      .grupoDocumentos(grupodocumentos)
      //.situacaoDocumentoDispensados(situacaoDocumentoDispensados)
      .build();
  }

  private CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> resultadoPesquisaBuild(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return documentoDispensadoPesquisarService.pesquisar(filtroConsulta);
  }
}
