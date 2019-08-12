import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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
  private paraPesquisarResource :DocumentoDispensadoParaPesquisarResource;

  constructor(
    private activatedRoute: ActivatedRoute,
    private formBuilder: FormBuilder,
    private documentoDispensadoApiService: DocumentoDispensadoApiService
  ) { }

  public ngOnInit() {
    this.paraPesquisarResource = this.activatedRoute.snapshot.data.resolver as DocumentoDispensadoParaPesquisarResource;
    this.filtroConsulta = new DocumentoDispensadoFiltroConsulta(this.activatedRoute.snapshot.queryParams);

    this.acoes = new Acoes(this.paraPesquisarResource.acoes);
    this.resultadoPesquisa = this.paraPesquisarResource.resultadoPesquisa;
    this.dadosParaFormulario = new DadosParaFormulario(this.paraPesquisarResource.dadosParaFormulario);
    this.pesquisarFormGroup = this.onInitFormGroupBuild(this.paraPesquisarResource.dadosFormulario);
  }

  limparForm() {
    this.pesquisarFormGroup.reset();
  }

  public desativar(item: DocumentoDispensadoResultadoPesquisaResource) {
    alert("Solicitou" + item.id);
  }

  public gerarRelatorioExcel() {
    const filtroConsulta = this.filtroConsultaBuild();

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

  public onChangeGrupoDocumento(){
    const gruposSelecionados = this.pesquisarFormGroup.value.grupoDocumentos;
    if(!gruposSelecionados || gruposSelecionados.length > 0){
      this.pesquisarFormGroup.controls['vigenciaFim'].enable();
      this.dadosParaFormulario.documentos =
        this.paraPesquisarResource.dadosParaFormulario.documentos.filter(item => item.nome === 'Documento 001 do GRP02');
    } else {
      this.pesquisarFormGroup.controls['vigenciaFim'].disable();
      this.dadosParaFormulario.documentos = this.paraPesquisarResource.dadosParaFormulario.documentos;
    }
  }

  private filtroConsultaBuild(): DocumentoDispensadoFiltroConsulta {
    this.filtroConsulta.grupoDocumentos = FiltroConsultaUtil.converteObjectToIds(this.pesquisarFormGroup.value.grupoDocumentos);
    this.filtroConsulta.documentos = FiltroConsultaUtil.converteObjectToIds(this.pesquisarFormGroup.value.documentos);
    this.filtroConsulta.clientes = FiltroConsultaUtil.converteObjectToIds(this.pesquisarFormGroup.value.clientes);
    this.filtroConsulta.vigenciaInicio = this.pesquisarFormGroup.value.vigenciaInicio;
    this.filtroConsulta.vigenciaFim = this.pesquisarFormGroup.value.vigenciaFim;

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
      vigenciaInicio: [null],
      vigenciaFim: [{value: 't', disabled: true}, [Validators.required, Validators.maxLength(5)]]
    });
  }
}
