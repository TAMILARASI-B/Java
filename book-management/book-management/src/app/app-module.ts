import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Login } from './login/login';
import { Register } from './register/register';
import { BookList } from './book-list/book-list';
import { BookForm } from './book-form/book-form';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';

@NgModule({
  declarations: [
   
  ],
  imports: [
     BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
        App,
    Login,
    Register,
    BookList,
    BookForm
    
  ],
  providers: [
   provideHttpClient(withFetch())
  ],
  
})
export class AppModule { }
