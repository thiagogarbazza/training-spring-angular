import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { DocumentoDispensadoRoutingModule } from '@app/documento-dispensado/routes/documento-dispensado-routing.module';
import { DocumentoDispensadoPesquisarComponent } from '@app/documento-dispensado/views/documento-dispensado-pesquisar/documento-dispensado-pesquisar.component';
import { SharedModule } from '@shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    DocumentoDispensadoPesquisarComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,

    SharedModule,
    DocumentoDispensadoRoutingModule
  ]
})
export class DocumentoDispensadoModule {

}
