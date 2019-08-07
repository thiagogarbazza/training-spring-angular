import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaginaPesquisaComponent } from './components/pagina-pesquisa/pagina-pesquisa.component';
import { SimpleMessagesComponent } from './components/simple-messages/simple-messages.component';

const EXPORTAR = [
  PaginaPesquisaComponent,
  SimpleMessagesComponent
];

@NgModule({
  declarations: [... EXPORTAR],
  exports: [... EXPORTAR],
  imports: [
    CommonModule
  ]
})
export class SharedModule { }
