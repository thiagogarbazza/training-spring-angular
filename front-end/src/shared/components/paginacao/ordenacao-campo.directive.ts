import { Directive, Input, Output, EventEmitter, HostListener, HostBinding } from '@angular/core';

@Directive({
  selector: '[appOrdenacaoCampo]'
})
export class OrdenacaoCampoDirective {

  @Input('appOrdenacaoCampo') campo: string;

  direcao: string;

  @Output() ordenarPesquisa: EventEmitter<any> = new EventEmitter();

  @HostBinding('class.sortable') ordenavel = true;
  @HostBinding('class.sortable-asc') asc;
  @HostBinding('class.sortable-desc') desc;

  constructor() {
  }


  @HostListener('click')
  public emitirOrdenacaoPesquisar() {
    const iniciado = this.asc || this.desc;

    const ordenacao = {
      campo: this.campo,
      direcao: !iniciado ? "ASC" : this.asc ? "DESC" : "ASC"
    };

    this.ordenarPesquisa.emit(ordenacao);
  }

  setarDirecao(dir) {
    this.direcao = dir;
    if (this.direcao == 'ASC') {
      this.asc = true;
      this.desc = false;
    } else if (this.direcao == 'DESC'){
      this.asc = false;
      this.desc = true;
    } else {
      this.asc = false;
      this.desc = false;
    }
  }
}
