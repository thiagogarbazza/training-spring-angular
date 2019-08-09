import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

import { DocumentoDispensadoParaPesquisarResource, DadosParaFormulario, DadosFormulario, Acoes } from '@app/documento-dispensado/models/documento-dispensado-para-pesquisar-resource';
import { Paginacao } from '@shared/components/paginacao/paginacao';
import { Ordenacao } from '@shared/components/paginacao/ordenacao';
import { DocumentoDispensadoFiltroConsulta } from '@app/documento-dispensado/models/documento-dispensado-filtro-consulta';
import { DocumentoDispensadoResultadoPesquisaResource } from '@app/documento-dispensado/models/documento-dispensado-resultado-pesquisa-resource';
import { CustomPageResource } from '@shared/models/custom-page-resource';
import { DocumentoDispensadoApiService } from '@app/documento-dispensado/services/documento-dispensado-api.service';
import { FiltroConsultaUtil } from '@shared/utils/filtro-consulta-utils';

@Component({
  selector: 'app-documento-dispensado-pesquisar',
  templateUrl: './documento-dispensado-pesquisar.component.html',
  styleUrls: ['./documento-dispensado-pesquisar.component.sass']
})
export class DocumentoDispensadoPesquisarComponent implements OnInit {

  public acoes: Acoes;
  public dadosParaFormulario: DadosParaFormulario;
  public resultadoPesquisa: CustomPageResource<DocumentoDispensadoResultadoPesquisaResource>;
  public pesquisarFormGroup: FormGroup;
  private filtroConsulta: DocumentoDispensadoFiltroConsulta;

  constructor(
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
    private documentoDispensadoApiService: DocumentoDispensadoApiService
  ) { }

  public ngOnInit() {
    const paraPesquisarResource = this.activatedRoute.snapshot.data.resolver as DocumentoDispensadoParaPesquisarResource;
    this.filtroConsulta = new DocumentoDispensadoFiltroConsulta(this.activatedRoute.snapshot.queryParams);

    this.acoes = new Acoes(paraPesquisarResource.acoes);
    this.resultadoPesquisa = paraPesquisarResource.resultadoPesquisa;
    this.dadosParaFormulario = paraPesquisarResource.dadosParaFormulario;
    this.pesquisarFormGroup = this.onInitFormGroupBuild(paraPesquisarResource.dadosFormulario);

  }

  limparForm() {
    this.pesquisarFormGroup.reset();
  }

  public desativar(item: DocumentoDispensadoResultadoPesquisaResource) {
    alert("Solicitou" + item.id);
  }

  public gerarRelatorioExcel() {
    const filtroConsulta = this.filtroConsultaBuild();
    filtroConsulta.numeroPagina = 0;
    filtroConsulta.ordenacaoCampo = undefined;
    filtroConsulta.ordenacaoDirecao = undefined;

    return this.documentoDispensadoApiService.gerarRelatorioExcel(filtroConsulta);
  }

  public pesquisar() {
    const filtroConsulta = this.filtroConsultaBuild();
    filtroConsulta.numeroPagina = 0;
    filtroConsulta.ordenacaoCampo = undefined;
    filtroConsulta.ordenacaoDirecao = undefined;

    return this.pesquisarNoServidor(filtroConsulta);
  }

  public ordenarGrid(ordenacao: Ordenacao) {
    const filtroConsulta = this.filtroConsultaBuild();
    filtroConsulta.ordenacaoCampo = ordenacao.field;
    filtroConsulta.ordenacaoDirecao = ordenacao.direction;

    return this.pesquisarNoServidor(filtroConsulta);
  }

  public navegacaoGrid(paginacao: Paginacao) {
    const filtroConsulta = this.filtroConsultaBuild();
    filtroConsulta.numeroPagina = paginacao.numeroPagina;
    filtroConsulta.quantidadePorPagina = paginacao.quantidadePorPagina;
    filtroConsulta.ordenacaoCampo = paginacao.ordenacaoCampo;
    filtroConsulta.ordenacaoDirecao = paginacao.ordenacaoDirecao;

    return this.pesquisarNoServidor(filtroConsulta);
  }

  private filtroConsultaBuild(): DocumentoDispensadoFiltroConsulta {
    this.filtroConsulta.grupoDocumentos = FiltroConsultaUtil.converteObjectToIds(this.pesquisarFormGroup.value.grupoDocumentos);
    this.filtroConsulta.documentos = FiltroConsultaUtil.converteObjectToIds(this.pesquisarFormGroup.value.documentos);
    this.filtroConsulta.clientes = FiltroConsultaUtil.converteObjectToIds(this.pesquisarFormGroup.value.clientes);

    return this.filtroConsulta;
  }

  private pesquisarNoServidor(filtroConsulta: DocumentoDispensadoFiltroConsulta) {
    return this.documentoDispensadoApiService.pesquisar(filtroConsulta).subscribe(resultado => {
      this.resultadoPesquisa = resultado;
    });
  }

  private onInitFormGroupBuild(dadosFormulario: DadosFormulario) {
    return this.formBuilder.group({
      grupoDocumentos: [dadosFormulario.grupoDocumentos],
      documentos: [dadosFormulario.documentos],
      clientes: [dadosFormulario.clientes],
    });
  }
}
