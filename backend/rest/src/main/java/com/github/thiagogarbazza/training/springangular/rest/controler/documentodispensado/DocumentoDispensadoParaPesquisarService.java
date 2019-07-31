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
import com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource.Acoes;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource.DadosFormulario;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource.DocumentoDispensadoParaPesquisarResource.DadosParaFormulario;
import com.github.thiagogarbazza.training.springangular.rest.controler.documentodispensado.resource.DocumentoDispensadoResultadoPesquisaResource;
import com.github.thiagogarbazza.training.springangular.rest.controler.grupodocumento.resource.GrupoDocumentoParaSelecaoResource;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.util.persistence.entity.IdentifiableUtil.findIdentifiablesByIds;
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

  DocumentoDispensadoParaPesquisarResource paraPesquisar(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    DadosParaFormulario dadosParaFormulario = dadosParaFormularioBuild();
    Acoes acoes = acoesBuild();
    DadosFormulario dadosFormulario = dadosFormularioBuild(dadosParaFormulario, filtroConsulta);
    CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> resultadoPesquisa = resultadoPesquisaBuild(filtroConsulta);

    return DocumentoDispensadoParaPesquisarResource.builder()
      .acoes(acoes)
      .dadosParaFormulario(dadosParaFormulario)
      .dadosFormulario(dadosFormulario)
      .resultadoPesquisa(resultadoPesquisa)
      .build();
  }

  private Acoes acoesBuild() {
    return Acoes.builder()
      .podeGerarExcel(true)
      .podeIncluir(true)
      .build();
  }

  private DadosFormulario dadosFormularioBuild(final DadosParaFormulario dadosParaFormulario, final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return DadosFormulario.builder()
      .clientes(findIdentifiablesByIds(dadosParaFormulario.getClientes(), filtroConsulta.getClientes()))
      .documentos(findIdentifiablesByIds(dadosParaFormulario.getDocumentos(), filtroConsulta.getDocumentos()))
      .grupoDocumentos(findIdentifiablesByIds(dadosParaFormulario.getGrupoDocumentos(), filtroConsulta.getGrupoDocumentos()))
      .dataBaseInicio(filtroConsulta.getDataBaseInicio())
      .dataBaseFim(filtroConsulta.getDataBaseFim())
      .situacaoDocumentoDispensados(filtroConsulta.getSituacoes())
      .build();
  }

  private DadosParaFormulario dadosParaFormularioBuild() {
    final Collection<Cliente> clientes = clienteConsultaService.pesquisar();
    final Collection<Documento> documentos = documentoConsultaService.pesquisar(DocumentoFiltroConsulta.builder().build());
    final Collection<GrupoDocumento> grupodocumentos = grupoDocumentoConsultaService.pesquisar(GrupoDocumentoFiltroConsulta.builder().build());
    final Collection<SituacaoDocumentoDispensado> situacaoDocumentoDispensados = asList(SituacaoDocumentoDispensado.values());

    return DadosParaFormulario.builder()
      .clientes(mapper.mapAsList(clientes, ClienteParaSelecaoResource.class))
      .documentos(mapper.mapAsList(documentos, DocumentoParaSelecaoResource.class))
      .grupoDocumentos(mapper.mapAsList(grupodocumentos, GrupoDocumentoParaSelecaoResource.class))
      .situacaoDocumentoDispensados(situacaoDocumentoDispensados)
      .build();
  }

  private CustomPageResource<DocumentoDispensadoResultadoPesquisaResource> resultadoPesquisaBuild(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return documentoDispensadoPesquisarService.pesquisar(filtroConsulta);
  }
}
