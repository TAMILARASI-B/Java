import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Home } from './home/home';
import { Gallery } from './gallery/gallery';
import { Contactus } from './contactus/contactus';
import { Login } from './login/login';
import { Signup } from './signup/signup';
import { Navbar } from './navbar/navbar';
import { Veg } from './veg/veg';
import { Nonveg } from './nonveg/nonveg';
import { Desert } from './desert/desert';

const routes: Routes = [
  {path:'home',
   component:Home},
  {
   path:'gallery',
   component:Gallery
  },
  {path:'contactus',
  component:Contactus
  },
  {path:'login',
   component:Login
  },
  {
   path:'signup',
   component:Signup
  },
  {
    path:'navbar',
    component:Navbar
  },
  {
    path:'veg',
    component:Veg
  },
  {
    path:"nonveg",
    component:Nonveg
  },
  {
    path:"desert",
    component:Desert
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
