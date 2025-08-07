import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Signup } from './signup/signup';
import { Login } from './login/login';
import { Home } from './home/home';
import { Contactus } from './contactus/contactus';

const routes: Routes = [
  { path: '', component: Home },
  { path: 'home', component: Home },
  { path: 'login', component: Login},
  { path: 'signup', component: Signup },
  { path: 'contactus', component: Contactus }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
