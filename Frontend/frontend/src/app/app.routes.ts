import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { PessoaListagemComponent } from './pessoa-listagem/pessoa-listagem.component';
import { PessoaFormComponent } from './pages/pessoa-form/pessoa-form.component';




export const routes: Routes = [
    
    {
        path: 'pessoas/login', component: LoginComponent,
        title: 'Login'
    },
    {
        path: 'pessoas', component: PessoaListagemComponent,
        title: 'Lista de Pessoas'
    },
    {
        path: 'pessoas/incluir',
        component: PessoaFormComponent,
        title: 'Pessoas - Incluir'
    },
    {
        path: 'pessoas/alterar/:id',
        component: PessoaFormComponent,
        title:'Pessoas - Alterar'
    },
   
];
