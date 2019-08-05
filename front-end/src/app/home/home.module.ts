import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardComponent } from '@app/home/views/dashboard/dashboard.component';
import { HomeRoutingModule } from '@app/home/routes/home-routing.module';

@NgModule({
  declarations: [
    DashboardComponent
  ],
  entryComponents: [
  ],
  imports: [
    CommonModule,
    HomeRoutingModule
  ],
  providers: [
  ]
})
export class HomeModule { }
