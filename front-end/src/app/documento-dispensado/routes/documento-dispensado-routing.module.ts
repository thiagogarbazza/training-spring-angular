import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DocumentoDispensadoPesquisarComponent } from '@app/documento-dispensado/views/documento-dispensado-pesquisar/documento-dispensado-pesquisar.component';
import { DocumentoDispensadoParaPesquisarResolver } from '@app/documento-dispensado/services/documento-dispensado-api.service';

const MODULE_ROUTES: Routes = [
  {
    path: 'documento-dispensado',
    component: DocumentoDispensadoPesquisarComponent,
    resolve: {resolver: DocumentoDispensadoParaPesquisarResolver},
    //canActivate: [NgxPermissionsGuard],
    //data: {
    //    permissions: {
     //       only: ['SLIM100', 'SLIM200', 'SLIM600'],
     //       redirectTo: 'acesso-negado'
     //   }
    //}
  }
];

@NgModule({
  exports: [RouterModule],
  imports: [
    RouterModule.forRoot(MODULE_ROUTES, {
      useHash: true,
      enableTracing: false
  })
  ],
  providers: [],
  declarations: []
})
export class DocumentoDispensadoRoutingModule { }
