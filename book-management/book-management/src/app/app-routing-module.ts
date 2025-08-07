import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Login } from './login/login';
import { Register } from './register/register';
import { BookList } from './book-list/book-list';
import { BookForm } from './book-form/book-form';
import { Auth } from './auth';

export const routes: Routes = [

   { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: Login },
  { path: 'register', component: Register },
  { path: 'books', component: BookList, canActivate: [Auth] },
  { path: 'books/add', component: BookForm, canActivate: [Auth] },
  { path: 'books/edit/:id', component: BookForm, canActivate: [Auth] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
