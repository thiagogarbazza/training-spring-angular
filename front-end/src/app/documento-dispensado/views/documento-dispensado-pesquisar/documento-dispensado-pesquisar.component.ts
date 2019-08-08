import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

import { DocumentoDispensadoParaPesquisarResource } from '@app/documento-dispensado/models/documento-dispensado-para-pesquisar-resource';
import { Paginacao } from '@shared/components/paginacao/paginacao';
import { Ordenacao } from '@shared/components/paginacao/ordenacao';
import { DocumentoDispensadoFiltroConsulta } from '@app/documento-dispensado/models/documento-dispensado-filtro-consulta';
import { DocumentoDispensadoResultadoPesquisaResource } from '@app/documento-dispensado/models/documento-dispensado-resultado-pesquisa-resource';
import { CustomPageResource } from '@shared/models/custom-page-resource';

@Component({
  selector: 'app-documento-dispensado-pesquisar',
  templateUrl: './documento-dispensado-pesquisar.component.html',
  styleUrls: ['./documento-dispensado-pesquisar.component.sass']
})
export class DocumentoDispensadoPesquisarComponent implements OnInit {

  public paraPesquisarResource: DocumentoDispensadoParaPesquisarResource;
  public resultadoPesquisa: CustomPageResource<DocumentoDispensadoResultadoPesquisaResource>;
  public pesquisarFormGroup: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) { }

  public ngOnInit() {
    this.paraPesquisarResource = this.route.snapshot.data.resolver as DocumentoDispensadoParaPesquisarResource;
    this.resultadoPesquisa = this.paraPesquisarResource.resultadoPesquisa;
    this.onInitFormGroupBuild();
  }

  public pesquisar() {
    const filtro: any = this.filtroConsultaBuild();
    filtro.numeroPagina = 0;
    filtro.quantidadePorPagina = undefined;
    filtro.ordenacaoCampo = undefined;
    filtro.ordenacaoDirecao = undefined;

    return this.pesquisarNoServidor(filtro);
  }

  public ordenarGrid(ordenacao: Ordenacao) {
    const filtro: any = this.filtroConsultaBuild();
    filtro.ordenacaoCampo = ordenacao.field;
    filtro.ordenacaoDirecao = ordenacao.direction;

    return this.pesquisarNoServidor(filtro);
  }

  public navegacaoGrid(paginacao: Paginacao) {
    const filtro: any = this.filtroConsultaBuild();
    filtro.numeroPagina = paginacao.numeroPagina;
    filtro.quantidadePorPagina = paginacao.quantidadePorPagina;
    filtro.ordenacaoCampo = paginacao.ordenacaoCampo;
    filtro.ordenacaoDirecao = paginacao.ordenacaoDirecao;

    return this.pesquisarNoServidor(filtro);
  }


  private onInitFormGroupBuild() {
    this.pesquisarFormGroup = this.formBuilder.group({
      situacao: [null],
    });
  }

  private filtroConsultaBuild(): DocumentoDispensadoFiltroConsulta {
    return new DocumentoDispensadoFiltroConsulta();
  }

  private pesquisarNoServidor(filtro: DocumentoDispensadoFiltroConsulta) {
   // this.regimePrudencialService.pesquisar(filtro).subscribe(resultado => {
   //   this.resultadoVisivel = true;
   //   this.resultadoPesquisa = resultado;
   // });
  }


}
