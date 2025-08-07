import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Home } from './home/home';
import { Login } from './login/login';
import { Signup } from './signup/signup';
import { Gallery } from './gallery/gallery';
import { Contactus } from './contactus/contactus';
import { Veg } from './veg/veg';
import { Nonveg } from './nonveg/nonveg';
import { Desert } from './desert/desert';
import { Navbar } from './navbar/navbar';

@NgModule({
  declarations: [
    App,
    Home,
    Login,
    Signup,
    Gallery,
    Contactus,
    Veg,
    Nonveg,
    Desert,
    Navbar
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
