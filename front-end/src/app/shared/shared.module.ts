import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaginaPesquisaComponent } from './components/pagina-pesquisa/pagina-pesquisa.component';
import { SimpleMessagesComponent } from './components/simple-messages/simple-messages.component';
import { OrdenacaoCampoDirective } from './components/paginacao/ordenacao-campo.directive';
import { PaginacaoComponent } from './components/paginacao/paginacao.component';
import { FormsModule } from '@angular/forms';
import { NgForTrackByIdDirective } from './directives/ng-for-track-by/ng-for-track-by-id.directive';

const EXPORTAR = [
  PaginaPesquisaComponent,
  OrdenacaoCampoDirective,
  PaginacaoComponent,
  SimpleMessagesComponent,

  NgForTrackByIdDirective
];

@NgModule({
  declarations: [... EXPORTAR],
  exports: [... EXPORTAR],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class SharedModule { }
