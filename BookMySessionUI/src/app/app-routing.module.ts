import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BookingComponent } from './booking/booking.component';
import { ConfirmbookingComponent } from './confirmbooking/confirmbooking.component';

const routes: Routes = [
  {
    path:'home',
    component:HomeComponent
  },
  {
    path:'booking',
    component:BookingComponent
  },
  {
    path:'confirmbooking',
    component:ConfirmbookingComponent
  },
  { path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
