import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from '@app/home/views/dashboard/dashboard.component';

const MODULE_ROUTES: Routes = [
  {
    path: 'home/dashboard',
    component: DashboardComponent,
    //resolve: {resolver: EntradaArquivoParaPesquisaResolver},
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
export class HomeRoutingModule { }
