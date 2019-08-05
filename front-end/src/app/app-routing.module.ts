import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DashboardComponent } from '@app/home/views/dashboard/dashboard.component';

const APP_ROUTES: Routes = [
  { path: '', pathMatch: 'full', component: DashboardComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(APP_ROUTES, {
    useHash: true,
    enableTracing: false,
    onSameUrlNavigation: "reload"
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
