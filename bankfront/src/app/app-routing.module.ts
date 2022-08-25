import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './component/accueil/accueil.component';
import { LoginComponent } from './component/login/login.component';
import { UserDetailsComponent } from './component/user-details/user-details.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'login'
  },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'accueil',
    component: AccueilComponent
  },
  {
    path:'user',
    component: UserDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
