import { Component, OnInit, Input, Output, EventEmitter, QueryList, ContentChildren, AfterContentInit } from '@angular/core';


import { Paginacao } from '@shared/components/paginacao/paginacao';
import { OrdenacaoCampoDirective } from '@shared/components/paginacao/ordenacao-campo.directive';
import { CustomPageResource } from '@shared/models/custom-page-resource';

@Component({
  selector: 'app-paginacao',
  templateUrl: './paginacao.component.html',
  styleUrls: ['./paginacao.component.sass']
})
export class PaginacaoComponent implements OnInit, AfterContentInit {

  _pagina: CustomPageResource<any>;

  @ContentChildren(OrdenacaoCampoDirective) ordenacoesCampo : QueryList<OrdenacaoCampoDirective>;

  @Input() set pagina(value: CustomPageResource<any>) {
    this.paginacao = new Paginacao();
    this._pagina = value;
    if (this._pagina) {
      this.paginacaoNumeros = this.numbers(this._pagina.pageNumber, this._pagina.totalPages);
      this.paginacao.numeroPagina = this._pagina.pageNumber;
      this.paginacao.quantidadePorPagina = this._pagina.pageSize;
      if (this._pagina.sort) {
        this.paginacao.ordenacaoCampo = this._pagina.sort.field;
        this.paginacao.ordenacaoDirecao = this._pagina.sort.direction;
      }

      if (this.ordenacoesCampo) {
        this.ordenacoesCampo.forEach(oc => {
          if(oc.campo === this.paginacao.ordenacaoCampo) {
            oc.setarDirecao(this.paginacao.ordenacaoDirecao);
          } else {
            oc.setarDirecao(undefined);
          }
        });
      }
    }
  };

  @Output() navegacaoGrid = new EventEmitter();

  private PAGINATION_LENGTH = 7;

  opcoesRegistroPorPagina: Array<number>;
  paginacao: Paginacao;
  paginacaoNumeros: Array<number>;

  constructor() { }

  ngAfterContentInit() {
    this.ordenacoesCampo.forEach(oc => {
      if(oc.campo === this.paginacao.ordenacaoCampo) {
        oc.setarDirecao(this.paginacao.ordenacaoDirecao);
      } else {
        oc.setarDirecao(undefined);
      }
    });
  }

  ngOnInit() {
    this.preencherOpcoesRegistroPorPagina();
  }

  private preencherOpcoesRegistroPorPagina() {
    this.opcoesRegistroPorPagina = [5, 10, 20, 30, 40, 50, 100, 500, 1000];
  }

  public observerOnChangeQuantidadePorPagina() {
    this.paginacao.numeroPagina = 0;
    this.navegacaoGrid.emit(this.paginacao);
  }

  public navegarPorPagina(numeroPagina: number) {
    this.paginacao.numeroPagina = numeroPagina;
    this.navegacaoGrid.emit(this.paginacao);
  }


  numbers(page, totalPages) {
    let numbers = [];
    const buttons = this.PAGINATION_LENGTH;
    const half = Math.floor(buttons / 2);

    if (totalPages <= buttons) {
      numbers = this.numberRange(0, totalPages);
    } else if (page <= half) {
      numbers = this.numberRange(0, buttons - 2);
      numbers.push('...');
      numbers.push(totalPages - 1);
    } else if (page >= totalPages - 1 - half) {
      numbers = this.numberRange(totalPages - (buttons - 2), totalPages);
      numbers.splice(0, 0, '...');
      numbers.splice(0, 0, 0);
    } else {
      numbers = this.numberRange(page - half + 2, page + half - 1);
      numbers.push('...');
      numbers.push(totalPages - 1);
      numbers.splice(0, 0, '...');
      numbers.splice(0, 0, 0);
    }
    return numbers;
  }

  numberRange(len, start) {
    const out = [];
    let end;

    if (start === undefined) {
      start = 0;
      end = len;
    } else {
      end = start;
      start = len;
    }

    for (let i = start; i < end; i++) {
      out.push(i);
    }

    return out;
  }


}
