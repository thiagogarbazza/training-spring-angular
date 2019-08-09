import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaginaPesquisaComponent } from './components/pagina-pesquisa/pagina-pesquisa.component';
import { SimpleMessagesComponent } from './components/simple-messages/simple-messages.component';
import { OrdenacaoCampoDirective } from './components/paginacao/ordenacao-campo.directive';
import { PaginacaoComponent } from './components/paginacao/paginacao.component';
import { FormsModule } from '@angular/forms';
import { NgForTrackByIdDirective } from './directives/ng-for-track-by/ng-for-track-by-id.directive';
import { NgbModule, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { NgbDateCustomParserFormatter } from './configurations/ngb-date-custom-parser-formatter';

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
    FormsModule,
    NgbModule
  ],
  providers: [
    {provide: NgbDateParserFormatter, useClass: NgbDateCustomParserFormatter}
  ]
})
export class SharedModule { }
